package cn.boommanpro.ip;



import cn.boommanpro.ip.model.CityConfig;
import cn.boommanpro.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class CityUtil {

    private static City city;
    private static final String DEFAULT_RESOURCE_PATH = "/ip/ipdb.datx";

    static {
        try {
            CityUtil.city = new City(DEFAULT_RESOURCE_PATH);
        } catch (IOException e) {
            log.error("ip工具类加载异常,{}", e.getMessage());
            e.printStackTrace();
        }
    }

    private static final String CITY_SPLIT = ";";


    public static boolean isHotCity(CityConfig cityConfig, String ip) {

        switch (cityConfig.getCityStrategy()) {
            case 1:
                return true;
            case 2:
                return false;
            default:
            case 0:
                return isHostCity(from2HotCities(cityConfig.getHotCities()), ip);
        }
    }


    private static boolean isHostCity(Set<String> hotCities, String ip) {
        String cityName;
        try {
            String[] strings = city.find(ip);
            if (StringUtils.isNullOrEmpty(strings[2])) {
                cityName = strings[1];
            } else {
                cityName = strings[2];
            }

            log.debug("用户ip:{} 解析后内容{},城市为:{},热门城市列表", ip, strings, cityName, hotCities);
            if (hotCities.contains(cityName)) {
                return true;
            }
        } catch (Exception e) {
            log.error("{} 异常ip:{} ,Exception:{}", CityUtil.class.getName(), ip, e.getMessage());
        }
        return false;
    }

    private static Set<String> from2HotCities(String hotCity) {
        return Arrays.stream(hotCity.split(CITY_SPLIT)).collect(Collectors.toSet());
    }

}
