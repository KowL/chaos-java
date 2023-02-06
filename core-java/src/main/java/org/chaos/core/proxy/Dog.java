package org.chaos.core.proxy;

/**
 * @ClassName: Dog
 * @Description: TODO
 * @Author: lijun
 * @Date: 2021-03-05 16:50
 */
public class Dog implements Animal {
    @Override
    public String hello() {
        System.out.println("汪汪汪汪汪");
        return "汪汪汪汪汪";
    }
}
