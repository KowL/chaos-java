package org.chaos.dubbo.registry;

import org.chaos.dubbo.common.URL;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-24 16:11
 * @Modified By:
 */
public interface Registry {

    void register(URL url);

    void unregister(URL url);
}
