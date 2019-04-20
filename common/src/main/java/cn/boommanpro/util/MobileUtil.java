package cn.boommanpro.util;

public class MobileUtil {

    /**
     * 判断字符串是否符合手机号码格式
     * 移动号段: 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
     * 联通号段: 130,131,132,145,155,156,170,171,175,176,185,186
     * 电信号段: 133,149,153,170,173,177,180,181,189
     *
     * @return 待检测的字符串
     */
    public static boolean isMobile(String mobileNums) {
        // "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        String telRegex = "^(0|86|17951)?(13[0-9]|15[012356789]|16[123456789]|17[0135678]|199|18[0-9]|14[579])[0-9|*]{4}[0-9]{4}$";

        if (StringUtils.isNullOrEmpty(mobileNums)) {
            return false;
        } else {
            return mobileNums.matches(telRegex);
        }

    }

    public static boolean isNotMobile(String mobileNums) {
        return !isMobile(mobileNums);
    }
}