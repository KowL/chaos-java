package org.chaos.dubbo.registry.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.chaos.dubbo.common.URL;
import org.chaos.dubbo.registry.AbstractRegistry;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-24 16:14
 * @Modified By:
 */
public class ZookeeperRegistry extends AbstractRegistry {

    private final CuratorFramework zkClient;

    private final String root = "dubbo";

    public ZookeeperRegistry(URL url) {
        super(url);
        String zkAddress = url.getAddress();
        zkClient = CuratorFrameworkFactory.builder()
                .connectString(zkAddress)
                .retryPolicy(new RetryNTimes(1, 1000))
                .build();
        zkClient.start();
    }

    @Override
    public void doRegister(URL url) {

    }
}
