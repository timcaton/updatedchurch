package org.stpaul.service;

import org.stpaul.configuration.BaseService;
import org.stpaul.model.ChurchMember;
import org.stpaul.repository.ChurchMemberRepository;

/**
 * Created by tjc4h on 3/10/2017.
 */
public interface ChurchMemberService extends BaseService<ChurchMember, ChurchMemberRepository> {
    ChurchMember findById(Long id);
}
