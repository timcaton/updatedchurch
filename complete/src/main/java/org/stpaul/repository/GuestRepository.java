package org.stpaul.repository;

import org.springframework.stereotype.Repository;
import org.stpaul.BaseJpaRepository;
import org.stpaul.model.ChurchMember;
import org.stpaul.model.Guest;

/**
 * Created by tjc4h on 4/3/2017.
 */
@Repository
public interface GuestRepository extends BaseJpaRepository<Guest, Long> {
    Guest findById(Long id);
}
