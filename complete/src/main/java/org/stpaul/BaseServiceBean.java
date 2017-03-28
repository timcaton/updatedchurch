package org.stpaul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;
import java.util.List;

@CacheConfig(
        cacheResolver = "customCacheResolver"
)
public abstract class BaseServiceBean<T extends TransactionalEntity, R extends BaseJpaRepository<T, Long>> implements BaseService<T, R> {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected R repository;

    public BaseServiceBean(){

    }

    public long count() {
        return this.repository.count();
    }

    @CachePut
    public List<T> findAll() {
        return this.repository.findAll();
    }

    @CachePut(
        key = "{root.targetClass, #id}"
    )
    @Transactional
    public T findById(Long id) {
        return (T) this.repository.findOne(id);
    }

    @CachePut(
        key = "{#root.targetClass, #result.id}"
    )
    @Transactional
    public T create(T entity) {
        if (entity.getId() != null) {
            this.logger.warn("Attempted to create entity with id attribute set");
            this.logger.warn("< create failed");
            throw new EntityExistsException("Cannot create new entity with id supplied");
        } else {
            return (T) this.repository.save(entity);
        }
    }

    @CachePut(
            key = "{#root.targetClass, #result.id}"
    )
    @Transactional
    public T update(T entity) {
        return (T) this.repository.save(entity);
    }

    @CachePut(
            key = "{root.targetClass, #id}"
    )
    @Transactional
    public void delete(Long id) {
        if(this.repository.findOne(id) != null){
            this.repository.delete(id);
        }
    }

    @CacheEvict(
        allEntries = true
    )
    public void evictCache(){

    }
}
