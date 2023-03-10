package com.electricvehicle.home.util;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

public class UrlUtil {
    public static String getBaseEnvLinkURL() {
        String baseEnvLinkURL = null;
        HttpServletRequest currentRequest = 
                ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        baseEnvLinkURL = "http://" + currentRequest.getLocalName();
        if(currentRequest.getLocalPort() != 80) {
            baseEnvLinkURL += ":" + currentRequest.getLocalPort();
        }
        if(!StringUtils.isEmpty(currentRequest.getContextPath())) {
            baseEnvLinkURL += currentRequest.getContextPath();
        }
        return baseEnvLinkURL;
    }
}
