package com.jobhunting.templates;

import java.util.HashSet;

/**
 * @description: set操作
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-24 16:19
 **/
public class SetOperations {
    HashSet hashSet = new HashSet();
    Object object = new Object();
    {
        hashSet.add(object);

        hashSet.remove(object);
        hashSet.clear();

        hashSet.isEmpty();
        hashSet.contains(object);
        hashSet.size();

        hashSet.toString();
        hashSet.toArray();
    }
}
