package cn.boommanpro.model.entity;



import lombok.ToString;
import me.ghui.fruit.annotations.Pick;


@ToString
public   class  Room {

    @Pick(value = ".more>a", attr = "href")
    private String url;

    @Pick(".t1")
    private String roomName;

    @Pick(".detail>p>span:eq(0)")
    private String area;

    @Pick(".detail>p>span:eq(1)")
    private String struct;

    @Pick(".room_tags")
    private String roomTags;

    @Pick(".price")
    private String price;

    public String getUrl() {
        if (url == null) {
            return null;
        }
        return "http:" + url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStruct() {
        return struct;
    }

    public void setStruct(String struct) {
        this.struct = struct;
    }

    public String getRoomTags() {
        return roomTags;
    }

    public void setRoomTags(String roomTags) {
        this.roomTags = roomTags;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}