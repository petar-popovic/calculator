package com.calculator.repository;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<T extends Serializable> {

	T getById(final Long id);

	List<T> getAll();

	void save(final T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final Long entityId);
	
	int deleteAll();
}
