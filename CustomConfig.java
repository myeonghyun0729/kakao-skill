package com.example.demo.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerTest.class);

    public final static String PROFILE_PROD_ONE = "prodOne";

    public final static String PROFILE_PROD_TWO = "prodTwo";

    public static String activeProfile;

    @PostConstruct
    public void init() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            activeProfile = ip.getHostAddress().equals("xxx.xxx.xxx") ? PROFILE_PROD_ONE : PROFILE_PROD_TWO;

            logger.info("activeProfile value : {}", activeProfile);
        } catch (UnknownHostException e) {
            logger.info("ip check failed : {}", e.getMessage());
        }
    }

    public static String getActiveProfile() {
        return activeProfile;
    }
}
