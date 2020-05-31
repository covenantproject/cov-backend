package org.covn.support;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

import org.apache.commons.lang3.tuple.Pair;

public class CopyHelper {

	private final Map<String, Pair<Field, Object>> fieldMap;
	private final Object src;

	private CopyHelper(Object src) {
		this.src = src;
		this.fieldMap = new HashMap<>();
		initObjectInfo(src.getClass());
	}

	private void initObjectInfo(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();

		for (Field f : fields) {
			boolean skip = false;
			boolean canAccess = false;
			try {
				canAccess = f.isAccessible();
			} catch (Exception ex) {
				skip = true;
			}
			if (skip == false) {
				try {
					f.setAccessible(true);
					String name = f.getName();

					Object value = f.get(this.src);
					Pair<Field, Object> info = Pair.of(f, value);
					fieldMap.put(name, info);

					System.out.println("********** " + name);
				} catch (Exception ex) {

				} finally {
					f.setAccessible(canAccess);
				}
			}
		}

		Class<?> parentClass = clazz.getSuperclass();
		if (parentClass.isInterface() == false && parentClass != Object.class) {
			initObjectInfo(parentClass);
		}

	}

	public Map<String, Pair<Field, Object>> getFieldMap() {
		return fieldMap;
	}

	public Object getSrc() {
		return src;
	}

	private void copyFrom(CopyHelper source,
			BiFunction<Pair<Field, Object>, Pair<Field, Object>, Boolean> fieldInterceptor) {

		for (Entry<String, Pair<Field, Object>> tEntry : this.fieldMap.entrySet()) {
			String tname = tEntry.getKey();
			Pair<Field, Object> tinfo = tEntry.getValue();
			Field tf = tinfo.getKey();

			Field sf = null;
			Object sValue = null;
			Pair<Field, Object> sinfo = source.getFieldMap().get(tname);
			if (sinfo != null) {
				sf = sinfo.getKey();
				sValue = sinfo.getValue();
			}

			if (fieldInterceptor == null || fieldInterceptor.apply(sinfo, tinfo) == true) {
				if (sinfo != null && tf.getType().isAssignableFrom(sf.getType())) {
					boolean skip = false;
					boolean tCanAccess = false;
					try {
						tCanAccess = tf.isAccessible();
					} catch (Exception ex) {
						skip = true;
					}

					if (skip == false) {
						try {
							tf.setAccessible(true);
							tf.set(this.src, sValue);
						} catch (Exception ex) {

						} finally {
							tf.setAccessible(tCanAccess);
						}
					}
				}
			}
		}

	}

	public static void cp(Object src, Object dest, BiFunction<Pair<Field, Object>, Pair<Field, Object>, Boolean> fieldInterceptor) {
		try {
			CopyHelper sh = new CopyHelper(src);
			CopyHelper th = new CopyHelper(dest);
			th.copyFrom(sh, fieldInterceptor);

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}


}
