package org.stpaul;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by tjc4h on 3/28/2017.
 */
public interface BaseJpaRepository<T extends TransactionalEntity, ID extends Serializable> extends JpaRepository<T, ID> {
}
