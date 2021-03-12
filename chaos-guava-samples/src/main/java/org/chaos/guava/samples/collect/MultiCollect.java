package org.chaos.guava.samples.collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-12-14 17:10
 * @Modified By:
 */
public class MultiCollect {

    public static void main(String[] args) {
        Multiset<String> hashMultiset = HashMultiset.create();
        hashMultiset.add("a");
        hashMultiset.add("b");
        hashMultiset.add("c");
        hashMultiset.add("a");
        hashMultiset.add("b");
        // 集合大小
        System.out.println(hashMultiset.size());
        // 元素Set
        System.out.println(hashMultiset.elementSet());

        hashMultiset.add("d", 3);
        System.out.println("hashMultiset add d");
        System.out.println("hashMultiset count d:" + hashMultiset.count("d"));

        hashMultiset.setCount("a", 3);
        System.out.println("hashMultiset set a count=3, " + hashMultiset);

        hashMultiset.remove("a");
        System.out.println(hashMultiset);
        hashMultiset.remove("a", 2);
        System.out.println(hashMultiset);
    }
}
