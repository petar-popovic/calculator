package com.calculator.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseRepositoryImpl< T extends Serializable> implements BaseRepository<T>{
 
    private Class< T> clazz;
    @PersistenceContext
    private EntityManager entityManager;
 
    public BaseRepositoryImpl(final Class< T> clazzToSet) {
        this.clazz = clazzToSet;
    }
 
    public T getById(final Long id) {
     //   Preconditions.checkArgument(id != null);
        return getEntityManager().find(clazz, id);
    }
 
    @SuppressWarnings("unchecked")
	public List< T> getAll() {
        return getEntityManager().createQuery("from " + clazz.getName())
                .getResultList();
    }
 
    public void save(final T entity) {
       // Preconditions.checkNotNull(entity);
        getEntityManager().persist(entity);
    }
 
    public T update(final T entity) {
       // Preconditions.checkNotNull(entity);
        return (T) getEntityManager().merge(entity);
    }
 
    public void delete(final T entity) {
       // Preconditions.checkNotNull(entity);
        getEntityManager().remove(entity);
    }
 
    public void deleteById(final Long entityId) {
        final T entity = getById(entityId);
        //Preconditions.checkState(entity != null);
        delete(entity);
    }
    
    public int deleteAll(){
    	int deletedCount = getEntityManager().createQuery("delete from "+clazz.getName()).executeUpdate();
    	return deletedCount;
    }
 
    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }
 
    /**
     * @param entityManager the entityManager to set
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
