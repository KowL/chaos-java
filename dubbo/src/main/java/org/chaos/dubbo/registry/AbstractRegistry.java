package org.chaos.dubbo.registry;

import org.chaos.dubbo.common.URL;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: lijun
 * @Description:
 * @Date: Created in 2020-08-24 16:11
 * @Modified By:
 */
public abstract class AbstractRegistry implements Registry {

    private final Map<URL, String> registered = new ConcurrentHashMap<>();

    private URL registryUrl;

    public AbstractRegistry(URL url) {
        setUrl(url);
    }

    @Override
    public void register(URL url) {
        // url 校验
        registered.put(url, "");

        try {
            doRegister(url);
        } catch (Exception e) {

        }
    }

    @Override
    public void unregister(URL url) {

    }

    public URL getUrl() {
        return registryUrl;
    }


    protected void setUrl(URL url) {
        if (url == null) {
            throw new IllegalArgumentException("registry url == null");
        }
        this.registryUrl = url;
    }


    // ==== Template method ====

    public abstract void doRegister(URL url);
}
