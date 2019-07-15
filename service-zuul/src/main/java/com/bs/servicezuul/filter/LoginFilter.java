package com.bs.servicezuul.filter;

import com.bs.servicezuul.util.Encrypt;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try{
            reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
            String line = null;
            while ((line = reader.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                if (null != reader){ reader.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        String accessToken = sb.toString().replaceAll(" ","").replaceAll("\"", "").replaceAll("\\{","").replaceAll("}","").split(":")[1];
        System.out.println(accessToken);
        String customerId = accessToken.split("-")[0];
//        System.out.println("================================"+customerId);
        if(!accessToken.equals(encrypt.getTokenByCustomerId(customerId))) {
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

