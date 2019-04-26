package cn.boommanpro.model.entity;

import lombok.Data;

import java.util.List;

/**
 * @author wangqm-b
 * @create 2018/6/25
 */
@Data
public class RoomJSON {
    /**
     * status : success
     * error_code : 0
     * error_message :
     * data : {"rooms":[{"id":"61245142","house_id":"60200153","code":"BJZRGY0818212544_02","house_code":"BJZRGY0818212544","status":"ycz","turn":1,"type":1,"name":"智学苑4居室-北卧","price":2590,"area":"8.9","price_unit":"元/月","bedroom":4,"parlor":1,"resblock_id":"1111027382721","resblock_name":"智学苑","lng":116.316963,"lat":40.056306,"face":"北","photo":"https://img.ziroom.com/pic/house_images/g2/M00/BF/E2/ChAFfVr1fcCAeGoVAAI_SCeXDII108.JPG_C_240_180_Q100.jpg","photo_webp":"https://img.ziroom.com/pic/house_images/g2/M00/BF/E2/ChAFfVr1fcCAeGoVAAI_SCeXDII108.JPG_C_240_180_Q100.webp","photo_min":"https://img.ziroom.com/pic/house_images/g2/M00/BF/E2/ChAFfVr1fcCAeGoVAAI_SCeXDII108.JPG_C_240_180_Q100.jpg","photo_min_webp":"https://img.ziroom.com/pic/house_images/g2/M00/BF/E2/ChAFfVr1fcCAeGoVAAI_SCeXDII108.JPG_C_240_180_Q100.webp","floor_total":"22","floor":"22","will_unrent_date":"20180707","subway_station_info":"距13号线西二旗站415米","house_type":1,"tags":[{"title":"自如客转租"},{"title":"集体供暖"},{"title":"米苏4.0"}],"type_text":"[转]自如友家"},{"id":"117812","house_id":"16037","code":"BJHD86435705_01","house_code":"BJHD86435705","status":"ycz","turn":1,"type":1,"name":"智学苑4居室-东南卧","price":3360,"area":"11.8","price_unit":"元/月","bedroom":4,"parlor":1,"resblock_id":"1111027382721","resblock_name":"智学苑","lng":116.316963,"lat":40.056306,"face":"东南","photo":"https://img.ziroom.com/pic/house_images/g2/M00/CF/15/ChAFfVo46dOARKLRAAv5lSNkyvg426.jpg_C_240_180_Q100.jpg","photo_webp":"https://img.ziroom.com/pic/house_images/g2/M00/CF/15/ChAFfVo46dOARKLRAAv5lSNkyvg426.jpg_C_240_180_Q100.webp","photo_min":"https://img.ziroom.com/pic/house_images/g2/M00/CF/15/ChAFfVo46dOARKLRAAv5lSNkyvg426.jpg_C_240_180_Q100.jpg","photo_min_webp":"https://img.ziroom.com/pic/house_images/g2/M00/CF/15/ChAFfVo46dOARKLRAAv5lSNkyvg426.jpg_C_240_180_Q100.webp","floor_total":"24","floor":"8","will_unrent_date":"20180628","subway_station_info":"距13号线西二旗站415米","house_type":1,"tags":[{"title":"自如客转租"},{"title":"集体供暖"},{"title":"木棉4.0"}],"type_text":"[转]自如友家"},{"id":"60167248","house_id":"60028083","code":"BJZRHD69265457_01","house_code":"BJZRHD69265457","status":"tzpzz","turn":0,"type":1,"name":"智学苑4居室-南卧","price":4060,"area":"约14.4","price_unit":"元/月","bedroom":4,"parlor":1,"resblock_id":"1111027382721","resblock_name":"智学苑","lng":116.316963,"lat":40.056306,"face":"南","photo":"https://img.ziroom.com/pic/static/images/slist_1207/defaultPZZ/buding-loading.jpg_C_240_180_Q100.jpg","photo_webp":"https://img.ziroom.com/pic/static/images/slist_1207/defaultPZZ/buding-loading.jpg_C_240_180_Q100.webp","photo_min":"https://img.ziroom.com/pic/static/images/slist_1207/defaultPZZ/buding-loading.jpg_C_240_180_Q100.jpg","photo_min_webp":"https://img.ziroom.com/pic/static/images/slist_1207/defaultPZZ/buding-loading.jpg_C_240_180_Q100.webp","floor_total":"22","floor":"4","will_unrent_date":"","subway_station_info":"距13号线西二旗站415米","house_type":1,"tags":[{"title":"独立卫生间"},{"title":"集体供暖"},{"title":"布丁3.0"}],"type_text":"自如友家"},{"id":"61164296","house_id":"60187396","code":"BJZRGY0818198790_03","house_code":"BJZRGY0818198790","status":"tzpzz","turn":0,"type":1,"name":"智学苑4居室-东卧","price":2790,"area":"约10.1","price_unit":"元/月","bedroom":4,"parlor":1,"resblock_id":"1111027382721","resblock_name":"智学苑","lng":116.316963,"lat":40.056306,"face":"东","photo":"https://img.ziroom.com/pic/static/images/slist_1207/defaultPZZ/misu-loading.jpg_C_240_180_Q100.jpg","photo_webp":"https://img.ziroom.com/pic/static/images/slist_1207/defaultPZZ/misu-loading.jpg_C_240_180_Q100.webp","photo_min":"https://img.ziroom.com/pic/static/images/slist_1207/defaultPZZ/misu-loading.jpg_C_240_180_Q100.jpg","photo_min_webp":"https://img.ziroom.com/pic/static/images/slist_1207/defaultPZZ/misu-loading.jpg_C_240_180_Q100.webp","floor_total":"6","floor":"6","will_unrent_date":"","subway_station_info":"距13号线西二旗站415米","house_type":1,"tags":[{"title":"集体供暖"},{"title":"离地铁近"},{"title":"米苏4.0"}],"type_text":"自如友家"},{"id":"60273485","house_id":"60044984","code":"BJZRGY081615434_02","house_code":"BJZRGY081615434","status":"tzpzz","turn":0,"type":1,"name":"智学苑4居室-南卧","price":3190,"area":"约10.2","price_unit":"元/月","bedroom":4,"parlor":1,"resblock_id":"1111027382721","resblock_name":"智学苑","lng":116.316963,"lat":40.056306,"face":"南","photo":"https://img.ziroom.com/pic/static/images/slist_1207/defaultPZZ/buding-loading.jpg_C_240_180_Q100.jpg","photo_webp":"https://img.ziroom.com/pic/static/images/slist_1207/defaultPZZ/buding-loading.jpg_C_240_180_Q100.webp","photo_min":"https://img.ziroom.com/pic/static/images/slist_1207/defaultPZZ/buding-loading.jpg_C_240_180_Q100.jpg","photo_min_webp":"https://img.ziroom.com/pic/static/images/slist_1207/defaultPZZ/buding-loading.jpg_C_240_180_Q100.webp","floor_total":"24","floor":"19","will_unrent_date":"","subway_station_info":"距13号线西二旗站415米","house_type":1,"tags":[{"title":"集体供暖"},{"title":"离地铁近"},{"title":"布丁4.0"}],"type_text":"自如友家"}],"options":[]}
     */

    private String status;
    private int error_code;
    private String error_message;
    private DataBean data;


    @Data
    public static class DataBean {
        private List<RoomsBean> rooms;
    }
}
