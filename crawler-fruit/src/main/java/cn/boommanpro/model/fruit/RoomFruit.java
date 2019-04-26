package cn.boommanpro.model.fruit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.ghui.fruit.annotations.Pick;

@Getter
@Setter
@ToString
public class RoomFruit {
    @Pick(value = ".lof-main-wapper>li:eq(0)>a",attr = "href")
    private String firstImg;

    @Pick(value = ".lof-main-wapper>li:last-child>a",attr = "href")
    private String lastImg;

}
