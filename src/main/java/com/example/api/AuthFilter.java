package com.example.api;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFilter extends ZuulFilter {
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
        return Boolean.TRUE;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String name = request.getParameter("name");
        String password = request.getParameter("pwd");

        if(name != null && name.equals("admin") && password != null && password.equals("admin")){
            return null;
        }else {
            ctx.unset();
            ctx.setResponseStatusCode(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED.value());
            return "AuthFailed";
        }

    }
}
