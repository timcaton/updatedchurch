package org.stpaul.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.stpaul.configuration.BaseServiceBean;
import org.stpaul.model.Guest;
import org.stpaul.repository.GuestRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by tjc4h on 4/3/2017.
 */
@Service
@CacheConfig(cacheResolver = "customCacheResolver")
public class GuestServiceBean extends BaseServiceBean<Guest, GuestRepository> implements GuestService {

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<Guest> findAll() {
        return null;
    }

    public Guest findById(@NotNull Long id) {return findById(id);
    }

    @Override
    public Guest create(Guest var1) {
        return null;
    }

    @Override
    public Guest update(Guest var1) {
        return null;
    }

    @Override
    public void delete(Long var1) {

    }

    @Override
    public void evictCache() {

    }

}
