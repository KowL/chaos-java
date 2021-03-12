package org.chaos.core.proxy;

/**
 * @ClassName: Dog
 * @Description: TODO
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: rick-li@msyc.cc
 * @Date: 2021-03-05 16:50
 */
public class Dog implements Animal {
    @Override
    public String hello() {
        System.out.println("汪汪汪汪汪");
        return "汪汪汪汪汪";
    }
}
