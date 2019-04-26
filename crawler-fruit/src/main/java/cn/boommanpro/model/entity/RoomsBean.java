package cn.boommanpro.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @author wangqm-b
 * @create 2018/6/25
 */


@Data
public class RoomsBean {

    /**
     * id : 61245142
     * house_id : 60200153
     * code : BJZRGY0818212544_02
     * house_code : BJZRGY0818212544
     * status : ycz
     * turn : 1
     * type : 1
     * name : 智学苑4居室-北卧
     * price : 2590
     * area : 8.9
     * price_unit : 元/月
     * bedroom : 4
     * parlor : 1
     * resblock_id : 1111027382721
     * resblock_name : 智学苑
     * lng : 116.316963
     * lat : 40.056306
     * face : 北
     * photo : https://img.ziroom.com/pic/house_images/g2/M00/BF/E2/ChAFfVr1fcCAeGoVAAI_SCeXDII108.JPG_C_240_180_Q100.jpg
     * photo_webp : https://img.ziroom.com/pic/house_images/g2/M00/BF/E2/ChAFfVr1fcCAeGoVAAI_SCeXDII108.JPG_C_240_180_Q100.webp
     * photo_min : https://img.ziroom.com/pic/house_images/g2/M00/BF/E2/ChAFfVr1fcCAeGoVAAI_SCeXDII108.JPG_C_240_180_Q100.jpg
     * photo_min_webp : https://img.ziroom.com/pic/house_images/g2/M00/BF/E2/ChAFfVr1fcCAeGoVAAI_SCeXDII108.JPG_C_240_180_Q100.webp
     * floor_total : 22
     * floor : 22
     * will_unrent_date : 20180707
     * subway_station_info : 距13号线西二旗站415米
     * house_type : 1
     * tags : [{"title":"自如客转租"},{"title":"集体供暖"},{"title":"米苏4.0"}]
     * type_text : [转]自如友家
     */


    private String id;

    @JSONField(name = "house_id")
    private String houseId;

    private String code;

    @JSONField(name = "house_code")
    private String houseCode;

    private String status;

    private int turn;

    private int type;

    private String name;


    private String area;

    @JSONField(name = "price_unit")
    private String priceUnit;

    private int bedroom;

    private int parlor;

    @JSONField(name = "resblock_id")
    private String resBlockId;

    @JSONField(name = "resblock_name")
    private String resBlockName;

    private double lng;

    private double lat;

    private String face;

    private String photo;

    @JSONField(name = "photo_webp")
    private String photoWebp;

    @JSONField(name = "photo_min")
    private String photoMin;

    @JSONField(name = "photo_min_webp")
    private String photoMinWebp;

    @JSONField(name = "floor_total")
    private String floorTotal;

    private String floor;

    @JSONField(name = "will_unrent_date")
    private String willUnRentDate;

    @JSONField(name = "subway_station_info")
    private String subwayStationInfo;

    @JSONField(name = "house_type")
    private int houseType;

    @JSONField(name = "type_text")
    private String typeText;

    private List<TagsBean> tags;

    private List<TestRoomBean.IntroListBean> introList;

    @JSONField(name = "area_order")
    private double areaOrder;
    @JSONField(name = "sort_score")
    private double sortScore;
    @JSONField(name = "subway_score")
    private int subwayScore;
    @JSONField(name = "has_video")
    private int hasVideo;
    @JSONField(name = "has_3d")
    private int has3d;
    @JSONField(name = "air_qualified")
    private int airQualified;
    @JSONField(name = "sale_img")
    private String saleImg;
    @JSONField(name = "sale_status")
    private int saleStatus;
    @JSONField(name = "price")
    private List<String> priceList;

    private int price;
    @Data
    public static class TagsBean {
        /**
         * title : 自如客转租
         */
        private String title;
        @JSONField(name = "bg_img")
        private String backgroundImg;
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
        @JSONField(name = "is_marked")
        private int marked;
    }
}
