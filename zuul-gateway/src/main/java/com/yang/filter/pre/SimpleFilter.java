package com.yang.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * Usage: <b> A simple filter executed before request is routed </b>
 *
 * @author Jingyi.Yang
 *         Date 2017/2/17
 **/
@Slf4j
public class SimpleFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("{} request to {}.", request.getMethod(), request.getRequestURL().toString());
        return null;
    }
}
