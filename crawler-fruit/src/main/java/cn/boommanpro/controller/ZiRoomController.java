package cn.boommanpro.controller;

import cn.boommanpro.common.CallResult;
import cn.boommanpro.model.dto.MobileQuery;
import cn.boommanpro.model.entity.RoomJSON;
import cn.boommanpro.model.entity.RoomsBean;
import cn.boommanpro.ocr.ZiRoomPriceGrab;
import cn.boommanpro.util.HttpQueryStringUtil;
import cn.boommanpro.util.HttpUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/ziRoom")
public class ZiRoomController {

    @RequestMapping("/search")
    public CallResult search(MobileQuery mobileQuery, String contains) {

        List<RoomsBean> roomsBeanList = new ArrayList<>();
        int startPageNum=1;
        String url="http://phoenix.ziroom.com/v7/room/list.json";
        String urlData;
        List<RoomsBean> roomsBeans;

        contains = contains == null ? "2室1厅" : contains;
        String queryString;
        do {
            mobileQuery.setPage(startPageNum);
            queryString= HttpQueryStringUtil.objectToQueryString(mobileQuery);
            urlData= HttpUtil.getUrlData(url+queryString);
            RoomJSON roomJSON = JSON.parseObject(urlData, RoomJSON.class);
            roomsBeans= roomJSON.getData().getRooms();
            for (RoomsBean roomsBean : roomsBeans) {
                if (roomsBean.getName().contains(contains)&&!roomsBean.getStatus().equals("ycz")){
                    roomsBeanList.add(roomsBean);
                }
                roomsBean.setPrice(ZiRoomPriceGrab.extractPrice(roomsBean.getPriceList().get(0),roomsBean.getPriceList().get(1)));

            }
            startPageNum++;
        } while (roomsBeans.size()!=0);

        return CallResult.success(roomsBeanList);
    }
}