package org.chaos.core.handle;

/**
 * handler接口
 *
 * @author lijun
 * @date 2022/7/20 18:43
 */
public interface BizHandler<T> {

    default boolean preHandler(T context) {
        return true;
    }

    boolean handle(T context);

}
