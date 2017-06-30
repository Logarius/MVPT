package git.osc.roland.mvpt.common.utils;

/**
 * Created by Roland on 2017/6/30.
 */
public class LogUtils {

    enum FLAG {
        DEBUG,
        RELEASE
    }

    public static FLAG flag = FLAG.DEBUG;

    public static String logMessage(String tag, String message) {
        return String.format("[%s] -- %s", tag, message);
    }

    public static void d(String tag, String message) {
        if (flag == FLAG.DEBUG) {
            System.out.println(logMessage(tag, message));
        }
    }

}
