package org.stpaul.repository;

import org.springframework.stereotype.Repository;
import org.stpaul.configuration.BaseJpaRepository;
import org.stpaul.model.ChurchMember;

/**
 * Created by tjc4h on 3/10/2017.
 */
@Repository
public interface ChurchMemberRepository extends BaseJpaRepository<ChurchMember, Long> {
    ChurchMember findById(Long id);
}
