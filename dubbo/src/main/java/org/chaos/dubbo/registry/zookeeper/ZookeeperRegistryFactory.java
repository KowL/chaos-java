package org.chaos.dubbo.registry.zookeeper;

import org.chaos.dubbo.common.URL;
import org.chaos.dubbo.registry.AbstractRegistry;
import org.chaos.dubbo.registry.AbstractRegistryFactory;
import org.chaos.dubbo.registry.Registry;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-24 16:14
 * @Modified By:
 */
public class ZookeeperRegistryFactory extends AbstractRegistryFactory {

    @Override
    protected Registry createRegistry(URL url) {
        return new ZookeeperRegistry(url);
    }
}
