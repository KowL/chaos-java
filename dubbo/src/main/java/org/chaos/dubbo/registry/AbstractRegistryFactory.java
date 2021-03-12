package org.chaos.dubbo.registry;

import org.chaos.dubbo.common.URL;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-24 16:31
 * @Modified By:
 */
public abstract class AbstractRegistryFactory implements RegistryFactory {

    @Override
    public Registry getRegistry(URL url) {
        return null;
    }

    protected abstract Registry createRegistry(URL url);
}
