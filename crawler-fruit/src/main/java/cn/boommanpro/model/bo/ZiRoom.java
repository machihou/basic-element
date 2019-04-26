package cn.boommanpro.model.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ZiRoom {

        private String url;

        private String roomName;

        private String area;

        private String struct;

        private String roomTags;

        private String price;

        private String firstImg;

        private String lastImg;

        //true可预订 false不可预订

        private boolean status=true;

}
