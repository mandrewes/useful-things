package tech.rsqn.cacheservice.interceptors;

import tech.rsqn.cacheservice.annotations.ReadOperation;

import org.aopalliance.intercept.MethodInvocation;

public class ReadInterceptor extends AbstractInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        InterceptorMetadata meta = InterceptorMetadata.with(this,
                resolveTarget(invocation, ReadOperation.class));

        return cacheService.aroundReadMethodInvocation(invocation, meta);
    }
}
