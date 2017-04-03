package org.stpaul.service;

import org.stpaul.BaseService;
import org.stpaul.model.ChurchMember;
import org.stpaul.model.Guest;
import org.stpaul.repository.ChurchMemberRepository;
import org.stpaul.repository.GuestRepository;

/**
 * Created by tjc4h on 4/3/2017.
 */
public interface GuestService extends BaseService<Guest, GuestRepository> {
    Guest findById(Long id);
}
