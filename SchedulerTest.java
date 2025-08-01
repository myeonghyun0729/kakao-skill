package com.example.demo.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class SchedulerTest {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerTest.class);

    private final String PROFILE_PROD_ONE = "prodOne";

    private final String PROFILE_PROD_TWO = "prodTwo";


    private static String activeProfile;

    @PostConstruct
    public void init() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            activeProfile = ip.getHostAddress().equals("xxx.xxx.xxx") ? PROFILE_PROD_ONE : PROFILE_PROD_TWO;
        } catch (UnknownHostException e) {
            logger.info("ip check failed : {}", e.getMessage());
        }
    }

    @Scheduled(fixedRate = 5000)
    public void scheduledTask() {
        // active profile check
        if (activeProfile == null || activeProfile.equals(PROFILE_PROD_ONE)) {
            logger.info("scheduler stop!");
            return;
        }
        logger.info("scheduler run!");
    }
}
