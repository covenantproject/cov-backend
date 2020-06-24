package org.covn.model;

import static org.covn.util.CovidUtils.cast;

import java.lang.reflect.Constructor;


public abstract class BaseModel<T, K>{

	public static final int copyDepth = 1;
	
	public abstract K getKey();

	public static <T> T of(Class<T> clazz) {
		try {
			Constructor<T> constructor = cast(clazz.getConstructor(new Class<?>[] {}));
			return (T) constructor.newInstance();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public abstract T copy();
	
}
