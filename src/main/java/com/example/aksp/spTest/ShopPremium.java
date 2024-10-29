package com.example.aksp.spTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Premium")
public class ShopPremium {

    Logger logger = LoggerFactory.getLogger(ShopPremium.class);

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        System.out.println(this.getClass());
        logger.warn(this.getClass()+"!!!!");
    }
}
