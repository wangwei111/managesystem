/**
 * *****************************************************
 * Copyright (C) 2020 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.starter.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 01/04/2020 10:07
 */
public class IPUtils {
    public IPUtils() {
    }

    public static String getClientRealip(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-ip");
        }

        if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-ip");
        }

        if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (null != ip && ip.length() > 15 && ip.indexOf(",") > 0) {
            ip = ip.substring(0, ip.indexOf(","));
        }

        return ip;
    }

    public static String getClientRealip2(HttpServletRequest request) {
        String ip = null;
        Enumeration enu = request.getHeaderNames();

        while(enu.hasMoreElements()) {
            String name = (String)enu.nextElement();
            if ("X-Forwarded-For".equalsIgnoreCase(name)) {
                ip = request.getHeader(name);
            } else if ("Proxy-Client-ip".equalsIgnoreCase(name)) {
                ip = request.getHeader(name);
            } else if ("WL-Proxy-Client-ip".equalsIgnoreCase(name)) {
                ip = request.getHeader(name);
            }

            if (null != ip && 0 != ip.length()) {
                break;
            }
        }

        if (null == ip || 0 == ip.length()) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    public static String getInnetIp() throws SocketException {
        String localip = null;
        String netip = null;
        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        boolean finded = false;

        while(netInterfaces.hasMoreElements() && !finded) {
            NetworkInterface ni = (NetworkInterface)netInterfaces.nextElement();
            Enumeration address = ni.getInetAddresses();

            while(address.hasMoreElements()) {
                ip = (InetAddress)address.nextElement();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    netip = ip.getHostAddress();
                    finded = true;
                    break;
                }

                if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    localip = ip.getHostAddress();
                }
            }
        }

        return netip != null && !"".equals(netip) ? netip : localip;
    }
}
