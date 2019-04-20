package cn.boommanpro.util;

/**
 * @author wangqm-b
 * @create 2018/5/2
 */
public class BeanUtils {

    public static void copyProperties(Object source, Object target){
        org.springframework.beans.BeanUtils.copyProperties(source,target);
    }
}
