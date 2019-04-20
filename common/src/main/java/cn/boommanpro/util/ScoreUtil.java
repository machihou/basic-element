package cn.boommanpro.util;

import java.util.Date;

/**
 * @author BoomMan
 * @mail 59232311@qq.com
 * @CreateTime 2018/11/5 19:04
 * @Version 1.0
 * @Description Redis 分数计算工具
 */
public class ScoreUtil {


    public static Double getRedisScore(Integer score)  {
        long nowSecond = System.currentTimeMillis();
//        String str = "2040-01-01 08:00:00.001";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//        Date date = sdf.parse(str);
        Date date = new Date(2208988800001L);
        long diff = date.getTime() - nowSecond;
        String scoreStr = score + "." + diff;
        return Double.parseDouble(scoreStr);
    }

    public static Integer getScore(Double redisScore) {
        return redisScore.intValue();
    }

}
