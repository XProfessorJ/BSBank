package com.bs.servicezuul.filter;

import com.bs.servicezuul.util.Encrypt;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(LoginFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Autowired
    Encrypt encrypt;

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        if (request.getRequestURL().toString().contains("authrization")){
            log.info("login");
            return null;
        }
        Object accessToken = request.getParameter("token");
        String customerId = accessToken.toString().split("-")[0];
        if(!accessToken.toString().equals(encrypt.getTokenByCustomerId(customerId))) {
            log.warn("token is error");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is error");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}

