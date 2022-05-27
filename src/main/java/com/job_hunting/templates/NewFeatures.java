package com.jobhunting.templates;

/**
 * @description:
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-25 10:12
 **/

import java.util.Arrays;
import java.util.List;

/**
 * 只包含一个抽象方法的接口称为 函数式接口
 * 四大函数式接口：
 * Interface Function<T,R>
 *     传入 T，返回 R
 *     T - 函数输入的类型  R - 函数的结果类型
 *
 * Interface Predicate<T>
 *     传入 T，返回 boolean
 *
 * Interface Supplier<T>
 *     只有返回值，返回值类型 T
 *
 * Interface Consumer<T>
 *     只有参数类型 T，没有返回值
 */
interface Lambda1{
     void test();
}

interface Lambda2{
    String test(String str);
}

interface Lambda3{
    void test(List list);
}

public class NewFeatures {
    public static void main(String[] args) {
        // lambda相当于重写方法 之后还要调用才行
        /**
         * Interface xxx = （参数列表）-> {操作代码,代码操作参数列表中的参数}；
         */
        Lambda1 lambda1 = () -> {
            System.out.println("123");
        };
        lambda1.test();

        /**
         * test2
         */
        String string = "hello,world !";
        Lambda2 lambda2 = (str)->{
            System.out.println(str);
            return str;
        };
        System.out.println(lambda2.test(string));

        /**
         * test3
         */
        List list = Arrays.asList(new String[]{"1", "2", "3"});
        // 方法引用，左侧是参数 :: 右侧是方法
        Lambda3 lambda3 = System.out::println;
        lambda3.test(list);


    }
}
