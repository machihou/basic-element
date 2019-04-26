package cn.boommanpro.model.info;

import java.util.List;


/**
 * 查找页面的介绍
 * 他包含 查找的关键词  具体到小区
 * 生成首次查找的html 为的是便于后期手动查询 二次验证
 * 关键词的房屋信息
 *
 *
 * @author BoomMan
 */
public class SearchInfo {

    private String pageName;
    private String pageHtml;
    private List<Room> rooms;

    /**
     * 房间应该有
     * 1.名称 如友家 · 智学苑4居室-北卧
     * 2.地址 可以根据url直接访问到房屋
     * 3.房间大小  根据房间大小直接判断
     * 4.房屋状态   ①转租中 ②关闭咨询 ③装修 ④退租 等等  这里需要另一个表进行连接查询
     * 5.房屋优点   集体供暖等 房屋风格也算
     * 6.房屋价格   至关重要  md 自如一直自己涨
     * 7.联系人姓名
     * 8.联系人电话
     */
     private static class Room {
        private String name;
        private String url;
        private String roomSize;
        private Integer status;
        private String content;
        private Long price;
        private String possessorName;
        private String possessorPhone;
    }
}
