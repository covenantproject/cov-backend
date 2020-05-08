package com.covid.service;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

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
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

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
			Set<Class<?>> entities = getClassesInPackage(Users.class);
			Set<Class<?>> fieldClasses = getClassesInPackage(Users_.class);
			Map<String, Class<?>> fieldClassMap = new HashMap<>();
			for (Class<?> clazz : fieldClasses) {
				fieldClassMap.put(clazz.getSimpleName(), clazz);
			}

			for (Class<?> entityClass : entities) {
				String cn = entityClass.getSimpleName()+"_";
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

	public static final Set<Class<?>> getClassesInPackage(Class<?> clazz)throws Exception {
		ClassPath path = ClassPath.from(clazz.getClassLoader());
		Set<ClassInfo> cinfoSet = path.getTopLevelClasses(clazz.getPackageName());
		Set<Class<?>> result = new HashSet<>();
		for(ClassInfo c: cinfoSet) {
			Class<?> z = c.load();
			result.add(z);
			//System.out.println(z.getName());
		}
		
		return result;
	}


}
;