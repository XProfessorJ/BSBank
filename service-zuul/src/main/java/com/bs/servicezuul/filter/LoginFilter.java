package com.bs.servicezuul.filter;

import com.bs.servicezuul.util.Encrypt;
import com.bs.servicezuul.util.EncryptUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@Component
@CrossOrigin
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
        if (request.getRequestURL().toString().contains("authrization")) {
            log.info("login");
            return null;
        }
        if (request.getMethod().equals("OPTIONS")) {
            return null;
        }
        String accessToken = "";
        try {
            accessToken = getHeader(request, "token");
        } catch (Exception e) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is null");
            } catch (Exception e1) {
            }
            return null;
        }

        System.out.println(accessToken);
        if (accessToken == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is null");
            } catch (Exception e) {
            }
            return null;
        }


        try {
            EncryptUtil des = new EncryptUtil("9ba45bfd500642328ec03ad8ef1b6e75", "utf-8");
            String tokenString = des.decode(accessToken);
            String customerId = tokenString.split("-")[0];
            if (!accessToken.equals(encrypt.getTokenByCustomerId(customerId))) {
                log.warn("token is error");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                try {
                    ctx.getResponse().getWriter().write("token is error");
                } catch (Exception e) {
                }

                return null;
            }
            log.info("ok");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return "token is error";
        }

    }

    private String getRequestParm(HttpServletRequest request) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sb.toString();
    }

    //get request headers
    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    private String getHeader(HttpServletRequest request, String headerName) {
        return request.getHeader(headerName);
    }

}

