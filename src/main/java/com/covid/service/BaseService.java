package com.covid.service;

import static com.covid.util.CovidUtils.cast;
//import static com.is.bowlq.util.BowlUtil.clean;
//import static com.is.bowlq.util.BowlUtil.format;

import java.util.List;
import java.util.function.Supplier;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import com.covid.model.BaseModel;
import com.covid.repository.Cond;
import com.covid.repository.EntityRepo;
import com.covid.support.CopyHelper;


public abstract class BaseService<E extends BaseModel<E, ?>> {

	public static final String loginUser = "loginUser";
	public static final String US = "United States";

	@Autowired
	protected EntityRepo repo;

	@Autowired
	private HttpSession session;

	private final Class<E> entityClazz;

	protected BaseService(Class<E> entityClazz) {
		this.entityClazz = entityClazz;
	}

	public List<E> findAll() {
		return findAll(this.entityClazz);
	}

	public <T> List<T> findAll(Class<T> clazz) {
		List<T> results = repo.find(Cond.of(clazz));
		return results;
	}

	public <K, T extends BaseModel<T, K>> T getByPk(Class<T> clazz, @NonNull Object pk) {
		T r = repo.findByPrimaryKey(clazz, pk);
		return r;
	}

	public <K, T extends BaseModel<T, K>> List<T> findByExample(@NonNull T entity) {
		System.out.println(entity.getClass().getName());
		return repo.findByExample(entity);
	}

	public <K, T extends BaseModel<T, K>> T findOneByExample(@NonNull T entity) {
		List<T> items = repo.findByExample(entity);
		T result = null;
		if (items.isEmpty() == false) {
			result = items.get(0);
		}
		return result;
	}

	public static <T> T one(Supplier<List<T>> itemsSupplier) {
		T item = null;
		List<T> items = itemsSupplier.get();
		if (items != null && items.size() == 1) {
			item = items.get(0);
		}
		return item;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <K, E extends BaseModel<E, K>> void save(E item) {
		if(item.getKey() != null) {
			item = this.mergeFromDb(item);
		}

		repo.save(item);

	}

	@SuppressWarnings("hiding")
	public final <K, E extends BaseModel<E, K>> E mergeFromDb(E entity) {
		E result = entity;
		if (entity.getKey() != null) {
			E db = cast(repo.findByPrimaryKey(entity.getClass(), entity.getKey()));
			if(db != null) {
				CopyHelper.cp(entity, db, (s, t) -> s.getValue() != null);
				result = db;
			}
		}
		return result;
	}


	public static final String FMT_USER_NAME = "%s %s%s %s";

//	public LoginUser getLoginUser() {
//		System.out.println("************ sessionId2 " + session.getId());
//		LoginUser user = cast(session.getAttribute(loginUser));
//		return user;
//	}

//	public String getLoginUserName() {
//		return getLoginUserName(null);
//	}

//	public String getLoginUserName(String defaultUser) {
//		LoginUser user = getLoginUser();
//		String userName = defaultUser;
//		if (user != null) {
//			userName = user.getUserName();
//		}
//		return userName;
//	}

	public void logout() {
		session.removeAttribute(loginUser);
	}



}
