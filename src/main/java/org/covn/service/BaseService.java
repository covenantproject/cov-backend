package org.covn.service;

import static org.covn.util.CovidUtils.cast;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.PreDestroy;

import org.covn.model.BaseModel;
import org.covn.repository.Cond;
import org.covn.repository.EntityRepo;
import org.covn.support.CopyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseService<E extends BaseModel<E, ?>> {

	public static final String loginUser = "loginUser";
	public static final String US = "United States";

	@Autowired
	protected EntityRepo repo;

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

	public void saveAll(List<E> items) {
		@SuppressWarnings("rawtypes")
		BaseModel[] arr = new BaseModel[items.size()];
		arr = items.toArray(arr);
		this.save(cast(arr));
	}
	
	@SuppressWarnings("unchecked")
	public void save(E... items) {
		for (E item : items) {
			if (item.getKey() != null) {
				item = this.mergeFromDb(item);
			}
			repo.save(item);
		}
	}

	public List<E> find(Cond<E> cond) {
		return repo.find(cond);
	}

	public <DTO> List<DTO> apply(List<E> items, Function<E, DTO> process) {
		List<DTO> result = new ArrayList<>();
		for (E item : items) {
			DTO dto = process.apply(item);
			result.add(dto);
		}
		return result;
	}


	public final E mergeFromDb(E entity) {
		E result = entity;
		if (entity.getKey() != null) {
			E db = cast(repo.findByPrimaryKey(entity.getClass(), entity.getKey()));
			if (db != null) {
				CopyHelper.cp(entity, db, (s, t) -> s.getValue() != null);
				result = db;
			}
		}
		return result;
	}

	public static final String FMT_USER_NAME = "%s %s%s %s";

	@PreDestroy
	@Transactional
	public void preDestroy() {
		this.repo.preDestory();
	}
	
}
