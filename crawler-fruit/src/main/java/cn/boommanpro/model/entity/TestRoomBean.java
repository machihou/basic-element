package cn.boommanpro.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class TestRoomBean {
    /**
     * id : 61888370
     * house_id : 60299513
     * code : BJZRGY0818323514_03
     * house_code : BJZRGY0818323514
     * status : dzz
     * turn : 0
     * type : 1
     * name : 智学苑4居室-南卧
     * price : ["//static8.ziroom.com/phoenix/pc/images/price/ba99db25b3be2abed93c50c7f55c332cs.png",[9,4,2,1]]
     * area : 8.69
     * price_unit : /月
     * bedroom : 4
     * parlor : 1
     * resblock_id : 1111027382721
     * resblock_name : 智学苑
     * lng : 116.316963
     * lat : 40.056306
     * face : 南
     * photo : https://img.ziroom.com/pic/house_images/g2m1/M00/77/0F/ChAFBlvpl4SAahq7AAspAX79cYg896.JPG_C_240_180_Q100.jpg
     * photo_webp : https://img.ziroom.com/pic/house_images/g2m1/M00/77/0F/ChAFBlvpl4SAahq7AAspAX79cYg896.JPG_C_240_180_Q100.webp
     * photo_min : https://img.ziroom.com/pic/house_images/g2m1/M00/77/0F/ChAFBlvpl4SAahq7AAspAX79cYg896.JPG_C_240_180_Q100.jpg
     * photo_min_webp : https://img.ziroom.com/pic/house_images/g2m1/M00/77/0F/ChAFBlvpl4SAahq7AAspAX79cYg896.JPG_C_240_180_Q100.webp
     * floor_total : 22
     * floor : 21
     * will_unrent_date :
     * subway_station_info : 距13号线西二旗站直线415米
     * house_type : 1
     * area_order : 8.69
     * sort_score : 6.9575
     * subway_score : 0
     * has_video : 0
     * has_3d : 0
     * air_qualified : 1
     * sale_img : https://image.ziroom.com/g2m1/M00/85/95/ChAFBlvugreAdUurAAAIJIioF8Q667.png
     * tags : [{"title":"深呼吸","bg_img":"https://image.ziroom.com/g2m1/M00/42/73/ChAFBlvW2J6AZtJtAAAfl2T06pY936.png"},{"title":"离地铁近"},{"title":"米苏4.0"}]
     * type_text : 合租
     * sale_status : 1
     * intro_list : [{"icon":"https://image.ziroom.com/g2m1/M00/66/71/ChAFB1vk_OSAA2ZBAAAEqwrFIBo493.png","title":"空气质量已检测, 空置已超过30天","is_marked":0},{"icon":"https://image.ziroom.com/g2m1/M00/67/9D/ChAFBlvk_QCAQ3tLAAAF1hO90gs983.png","title":"签约立减服务费666元","is_marked":1}]
     */

    private String id;
    private String house_id;
    private String code;
    private String house_code;
    private String status;
    private int turn;
    private int type;
    private String name;
    private String area;
    private String price_unit;
    private int bedroom;
    private int parlor;
    private String resblock_id;
    private String resblock_name;
    private double lng;
    private double lat;
    private String face;
    private String photo;
    private String photo_webp;
    private String photo_min;
    private String photo_min_webp;
    private String floor_total;
    private String floor;
    private String will_unrent_date;
    private String subway_station_info;
    private int house_type;
    private double area_order;
    private double sort_score;
    private int subway_score;
    private int has_video;
    private int has_3d;
    private int air_qualified;
    private String sale_img;
    private String type_text;
    private int sale_status;
    private List<String> price;
    private List<TagsBean> tags;
    private List<IntroListBean> intro_list;


    public static class TagsBean {
        /**
         * title : 深呼吸
         * bg_img : https://image.ziroom.com/g2m1/M00/42/73/ChAFBlvW2J6AZtJtAAAfl2T06pY936.png
         */

        private String title;
        private String bg_img;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBg_img() {
            return bg_img;
        }

        public void setBg_img(String bg_img) {
            this.bg_img = bg_img;
        }
    }

    @Data
    public static class IntroListBean {
        /**
         * icon : https://image.ziroom.com/g2m1/M00/66/71/ChAFB1vk_OSAA2ZBAAAEqwrFIBo493.png
         * title : 空气质量已检测, 空置已超过30天
         * is_marked : 0
         */

        private String icon;
        private String title;
        private int is_marked;

    }
}
