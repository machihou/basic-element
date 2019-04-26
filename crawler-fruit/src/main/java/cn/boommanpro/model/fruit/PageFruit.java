package cn.boommanpro.model.fruit;



import cn.boommanpro.model.entity.Room;
import lombok.ToString;
import me.ghui.fruit.annotations.Pick;

import java.util.List;


@ToString
public class PageFruit {

    private String url;

    @Pick("li.clearfix")
    private List<Room> roomList;

    @Pick(value = "#page>a.next",attr = "href")
    private String nextUrl;


    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNextUrl() {
        if (nextUrl==null){
            return null;
        }
        return "http:"+nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }
}
