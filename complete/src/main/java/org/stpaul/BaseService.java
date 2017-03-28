package org.stpaul;

import java.util.List;

/**
 * Created by tjc4h on 3/28/2017.
 */
public interface BaseService<T extends TransactionalEntity, R extends BaseJpaRepository<T, Long>> {
    long count();

    List<T> findAll();


    T findById(Long var1);

    T create(T var1);

    T update(T var1);

    void delete(Long var1);

    void evictCache();
}
