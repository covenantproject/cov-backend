package com.covid.service;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.covid.model.db.Users;
import com.covid.model.meta.Users_;
import com.covid.repository.EntityRepo;

@Component
@DependsOn({ "entityRepo" })
@Order(Ordered.LOWEST_PRECEDENCE)
public class JpaMetaModelSetupService implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private EntityRepo repo;

	@EventListener
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		EntityManager em = repo.getEntityManager();
		try {
			List<Class<?>> entities = getClassesInPackage(Users.class.getPackageName());
			List<Class<?>> fieldClasses = getClassesInPackage(Users_.class.getPackageName());
			Map<String, Class<?>> fieldClassMap = new HashMap<>();
			for (Class<?> clazz : fieldClasses) {
				fieldClassMap.put(clazz.getSimpleName(), clazz);
			}

			for (Class<?> entityClass : entities) {
				String cn = entityClass.getSimpleName() + "_";
				//System.out.println("********************************* " + cn);
				Class<?> metaClass = fieldClassMap.get(cn);
				if (metaClass != null) {

					ManagedType<?> data = em.getMetamodel().managedType(entityClass);
					List<Field> stringField = getFields(metaClass,
							(f) -> f.getType().equals(String.class) && Modifier.isFinal(f.getModifiers()));
					List<Field> entityFields = getFields(metaClass, (f) -> f.getType().equals(SingularAttribute.class));
					Map<String, Field> cols = new HashMap<>();
					for (Field f : entityFields) {
						cols.put(f.getName(), f);
					}

					for (Field f : stringField) {
						String fieldName = f.get(null).toString();
						@SuppressWarnings("rawtypes")
						SingularAttribute info = data.getSingularAttribute(fieldName);
						Field entityField = cols.get(fieldName);
						entityField.set(null, info);
					}
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		//System.out.println("********************* "+Account_.accountId.getName());
	}

	public static List<Field> getFields(Class<?> clazz, Function<Field, Boolean> test) throws Exception {
		List<Field> results = new ArrayList<>();
		for (Field field : clazz.getFields()) {
			if (test.apply(field)) {
				results.add(field);
			}
		}
		return results;
	}

	public static final List<Class<?>> getClassesInPackage(String packageName) {
		String path = packageName.replaceAll("\\.", File.separator);
		List<Class<?>> classes = new ArrayList<>();
		String[] classPathEntries = System.getProperty("java.class.path").split(System.getProperty("path.separator"));

		String name;
		for (String classpathEntry : classPathEntries) {
			if (classpathEntry.endsWith(".jar")) {
				File jar = new File(classpathEntry);
				try {
					JarInputStream is = new JarInputStream(new FileInputStream(jar));
					JarEntry entry;
					while ((entry = is.getNextJarEntry()) != null) {
						name = entry.getName();
						if (name.endsWith(".class")) {
							if (name.contains(path) && name.endsWith(".class")) {
								String classPath = name.substring(0, entry.getName().length() - 6);
								classPath = classPath.replaceAll("[\\|/]", ".");
								classes.add(Class.forName(classPath));
							}
						}
					}
					is.close();
				} catch (Exception ex) {
					// Silence is gold
				}
			} else {
				try {
					File base = new File(classpathEntry + File.separatorChar + path);
					for (File file : base.listFiles()) {
						name = file.getName();
						if (name.endsWith(".class")) {
							name = name.substring(0, name.length() - 6);
							classes.add(Class.forName(packageName + "." + name));
						}
					}
				} catch (Exception ex) {
					// Silence is gold
				}
			}
		}

		return classes;
	}

}
