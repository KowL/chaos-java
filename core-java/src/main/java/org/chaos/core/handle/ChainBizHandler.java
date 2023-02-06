package org.chaos.core.handle;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链链式处理器
 *
 * @author lijun
 * @date 2022/7/20 18:43
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ChainBizHandler<T> implements BizHandler<T> {

    private final String module;

    private final BizHandler[] handlers;

    private static final BizHandler[] EMPTY_HANDLERS = {};

    public static <T> BizHandler<T> chain(BizHandler... handlers) {
        return new ChainBizHandler<>(handlers);
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private String module;
        private List<BizHandler> handlers;

        protected Builder() {
        }

        public Builder<T> add(BizHandler handler) {
            if (handler != null) {
                if (handlers == null) { handlers = new ArrayList<>(10); }
                handlers.add(handler);
            }
            return this;
        }

        public Builder<T> module(String module) {
            this.module = module;
            return this;
        }

        public ChainBizHandler<T> build() {
            BizHandler[] handlerArray = handlers == null || handlers.isEmpty() ?
                    EMPTY_HANDLERS :
                    handlers.toArray(new BizHandler[handlers.size()]);
            return new ChainBizHandler<>(module, handlerArray);
        }
    }

    private ChainBizHandler(BizHandler[] handlers) {
        this(null, handlers);
    }

    private ChainBizHandler(String module, BizHandler[] handlers) {
        this.handlers = handlers == null ? EMPTY_HANDLERS : handlers;
        this.module = module;
    }

    public String getModule() {
        return module;
    }

    @Override
    public boolean handle(T context) {
        final BizHandler[] handlers = this.handlers;
        int pos = 0;
        int size = handlers.length;
        for (; pos < size; pos++) {
            BizHandler handler = handlers[pos];
            if (!handler.preHandler(context)) {
                return false;
            }
            if (!handler.handle(context)) {
                return false;
            }
        }
        return true;
    }

}
