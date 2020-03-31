package com.zh.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义Zuul过滤器
 * 这个过滤器是日志打印
 *
 * @author he.zhang
 * @date 2020/3/16 20:43
 */
public class LogFilter extends ZuulFilter {

    /**
     * 设置过滤器级别，
     * @return String
     */
    @Override
    public String filterType() {
        // pre，在路由之前使用
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 设置过滤器顺序
     * 数字越小，过滤器的优先级越高，最小的是0
     * 每个级别的过滤器都有默认配置，+1是为了在系统自带的过滤器之后执行
     * @return int
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    /**
     * 设置过滤器是否启动，默认false
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器业务逻辑
     * @return Object
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 当前请求的上下文，可以理解为一个map
        RequestContext context = RequestContext.getCurrentContext();
        // 获取HttpServletRequest
        HttpServletRequest request = context.getRequest();
        System.out.println(request.getRemoteAddr()+"访问了" + request.getRequestURI());
        return null;
    }
}
