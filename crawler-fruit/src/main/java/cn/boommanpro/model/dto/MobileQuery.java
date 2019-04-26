package cn.boommanpro.model.dto;


import cn.boommanpro.annotation.HttpQueryString;
import lombok.Data;

/**
 * @author wangqm-b
 * @create 2018/7/3
 */
@Data
public class MobileQuery {
    @HttpQueryString(name = "city_code")
    private String cityCode="110000";

    private String keywords;

    @HttpQueryString(name = "subway_code")
    private String subwayCode;

    private int sort=2;

    private int size = 10;

    private int page = 1;

    //price=4800,5000

    private String price="4500,7000";

    public void setPrice(Integer minPrice,Integer maxPrice) {
        if (minPrice==null&&maxPrice==null){
            this.price=",";
            return;
        }
        if (maxPrice==null){
            this.price = minPrice+",";
            return;
        }
        if (minPrice==null){
            this.price = ","+maxPrice;
            return;
        }
        this.price = minPrice + "," + maxPrice;
    }
}
