package tk.ip;

import tk.http.HttpUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP地址工具类
 */
public class IPUtils {
    
	private static  final  String IP_SEARCH_URL = "http://whois.pconline.com.cn/ipJson.jsp?ip=%s";
   
    /**
     * 获取IP地址所在省份|直辖市
     * @param ip
     * @return
     */
    public static String getAreaByIp(String ip) {
        String result = null;
        try {
            result =   HttpUtils.doGetRequest(String.format(IP_SEARCH_URL,ip));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int proIndex = result.indexOf("pro");
        int proCodeIndex = result.indexOf("proCode");
        return result.substring(proIndex+6,proCodeIndex-3);
    }

    /**
     * 	客户端正式IP地址
     * 	X-Forwarded-For的值并不止一个，而是一串Ｉｐ值
     * 	答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     	如：X-Forwarded-For：192.168.1.110， 192.168.1.120，
     192.168.1.130， 192.168.1.100用户真实IP为： 192.168.1.110
     */
    public static String getClientIp(HttpServletRequest req) {
        String ip =req.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip =  req.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 服务器端IP地址
     */
    public static String getServerIp() throws UnknownHostException {
        InetAddress add = InetAddress.getLocalHost();
        return add.getHostAddress();
    }

    /***
     *  判断Ip是否在某个IP段
     * @param ipSection Ip段 如192.168.168.0-192.168.168.255
     * @param ip Ip 192.168.18.243
     * @return
     */
    public static boolean ipIsValid(String ipSection, String ip) {
        ip = ip.trim();
        final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
        final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;
        if (!ipSection.matches(REGX_IPB) || !ip.matches(REGX_IP))
            return false;
        int idx = ipSection.indexOf('-');
        String[] sips = ipSection.substring(0, idx).split("\\.");
        String[] sipe = ipSection.substring(idx + 1).split("\\.");
        String[] sipt = ip.split("\\.");
        long ips = 0L, ipe = 0L, ipt = 0L;
        for (int i = 0; i < 4; ++i) {
            ips = ips << 8 | Integer.parseInt(sips[i]);
            ipe = ipe << 8 | Integer.parseInt(sipe[i]);
            ipt = ipt << 8 | Integer.parseInt(sipt[i]);
        }
        if (ips > ipe) {
            long t = ips;
            ips = ipe;
            ipe = t;
        }
        return ips <= ipt && ipt <= ipe;
    }
}
