package org.stpaul.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.stpaul.model.ChurchMember;
import org.stpaul.repository.ChurchMemberRepository;
import org.stpaul.service.ChurchMemberService;

/**
 * Created by tjc4h on 3/28/2017.
 */
@Component
@Profile("load_test_data")
public class MemberSeedData implements ApplicationListener<ContextRefreshedEvent>, Ordered {

    @Autowired
    private ChurchMemberRepository churchMemberRepository;

    @Autowired
    private ChurchMemberService churchMemberService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadChurchMemberSeedData();
    }

    private void loadChurchMemberSeedData(){
        ChurchMember churchMember = new ChurchMember();
        churchMember.setFirstName("Tim");
        churchMember.setLastName("Caton");

        churchMemberService.create(churchMember);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
