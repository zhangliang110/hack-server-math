package zl.hack;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

/**
 * Description : 
 * Copyright (c) Feifan
 * Author by ff_wind_zl 创建
 * @version 1.0
 * @date 2021.12.13 10:04
 */
public class HackClass implements ObjectFactory {

    static {
        System.out.println("=======静态代码");
    }

    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return "hack------------success";
    }
}
