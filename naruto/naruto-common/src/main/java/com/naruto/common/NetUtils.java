package com.naruto.common;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Pattern;

public class NetUtils {
    private static final Pattern IP_PATTERN = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3,5}$");

    private NetUtils() {
    }

    public static String getLocalIP() {
        InetAddress address = getLocalAddress();
        if (address == null) {
            return null;
        } else {
            String ip = address.getHostAddress();
            if (ip == null || "".equals(ip.trim()) || "0.0.0.0".equals(ip) || "127.0.0.1".equals(ip)) {
                ip = address.getHostName();
            }
            return ip;
        }
    }

    private static InetAddress getLocalAddress() {
        InetAddress localAddress;
        try {
            localAddress = InetAddress.getLocalHost();
            if (isValidAddress(localAddress)) {
                return localAddress;
            }
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            if (interfaces != null) {
                while (interfaces.hasMoreElements()) {
                    NetworkInterface network = interfaces.nextElement();
                    Enumeration<InetAddress> addresses = network.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        InetAddress address = addresses.nextElement();
                        if (isValidAddress(address)) {
                            return address;
                        }
                    }
                }
            }
        } catch (Exception var8) {
            localAddress = null;
        }
        return localAddress;
    }

    private static boolean isValidAddress(InetAddress address) {
        if (address != null && !address.isLoopbackAddress()) {
            String ip = address.getHostAddress();
            return ip != null && !"0.0.0.0".equals(ip) && !"127.0.0.1".equals(ip) && IP_PATTERN.matcher(ip).matches();
        } else {
            return false;
        }
    }
}
