package com.zcy.filter;

import com.zcy.common.Convert;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.profiler.Profiler;
import org.apache.dubbo.common.profiler.ProfilerEntry;
import org.apache.dubbo.rpc.*;

public class ProfilerFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        URL url = invoker.getUrl();
        ProfilerEntry bizProfiler = (ProfilerEntry) invocation.get(Profiler.PROFILER_KEY);

        //其实应该取平均值
        Convert.profilerEntryConcurrentHashMap.put(url.getParameter("serialization"), bizProfiler.getFirst());
        return invoker.invoke(invocation);
    }
}
