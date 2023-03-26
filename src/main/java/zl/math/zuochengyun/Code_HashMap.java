package zl.math.zuochengyun;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * Description: 设计一个含有setAll 方法的hashMap
 * Copyright (c) Feifan
 *
 * @version 1.0 2023/3/23 22:18 by zl 创建
 **/
public class Code_HashMap<K, V> {

    private HashMap<K, V> map = new HashMap<>();

    private HashSet<K> allSet = new HashSet<>();

    private V allValue = null;

    public V get(K key) {
        Long keyTimeStamp = timestampMap.get(key);
        if (Objects.isNull(keyTimeStamp)) {
            return null;
        }
        if (allValueV != null && (keyTimeStamp < allTimeStamp )) {
            return allValueV;
        }
        return outerMap.get(key);
    }

    public void setAll(V value) {
        time++;
        allValueV = value;
        allTimeStamp = time;

    }

    public void put(K key, V value) {
        time++;
        outerMap.put(key, value);
        timestampMap.put(key, time);
    }

    //外层map
    private Map<K, V> outerMap = new HashMap<>();

    //时间戳map
    private Map<K, Long> timestampMap = new HashMap<>();

    //所有value
    private V allValueV = null;

    //时间戳
    private Long allTimeStamp = Long.MAX_VALUE;

    private Long time = 0L;


    public static void main(String[] args) {
        Code_HashMap<String, String> codeHashMap = new Code_HashMap();
        codeHashMap.put("123", "333");
        codeHashMap.put("333", "4123");
        codeHashMap.setAll("11");
        String s = codeHashMap.get("123");
        System.out.println(s);
        codeHashMap.put("123", "xxx");
        String s1 = codeHashMap.get("123");
        System.out.println(s1);
        String s2 = codeHashMap.get("333");
        System.out.println(s2);
        codeHashMap.put("123", "xxxxxx");
        String s3 = codeHashMap.get("123");
        System.out.println(s3);
    }

}
