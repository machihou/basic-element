package cn.boommanpro.model.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class QueryResultBo {

    private String searchKey;

    private List<ZiRoom> ziRoomList;


}
