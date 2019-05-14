package cn.boommanpro.elasticsearch.bboss.dao;

import cn.boommanpro.elasticsearch.bboss.dto.WarningStatDto;
import cn.boommanpro.elasticsearch.bboss.model.Warnings;
import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.AggHit;
import org.frameworkset.elasticsearch.entity.ESAggDatas;
import org.frameworkset.elasticsearch.entity.MapRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class WarningsDao {

    @Autowired
    private BBossESStarter bbossESStarter;


    public void save(Warnings warnings) {
        ClientInterface clientUtil = bbossESStarter.getRestClient();
        String response = clientUtil.addDocument("monitor", "warning", warnings);
        log.debug("response:{}",response);
    }

    public List<WarningStatDto> queryWarningStat(List<String> planNameList){
        ClientInterface clientUtil = bbossESStarter.getConfigRestClient("cn/boommanpro/elasticsearch/bboss/dao/WarningsDao.xml");
        Map<String, Object> params = new HashMap<>(2);
        params.put("planNameList",planNameList);
        params.put("startTime","1553584903000");
        MapRestResponse response = clientUtil.search(
                "monitor/_search",
                "warningStat", params);
        return resolve(response);
    }

    @SuppressWarnings(value = "unchecked")
    private List<WarningStatDto> resolve(MapRestResponse response){
        List<Map<String,Object>> groupByNameList = (List<Map<String, Object>>) response.getAggBuckets("group_by_name");

        List<WarningStatDto> warningStatList = new ArrayList<>(groupByNameList.size());
        WarningStatDto warningStat;
        for (Map<String, Object> stringObjectMap : groupByNameList) {
            warningStat = new WarningStatDto();
            warningStat.setNoSign(Long.parseLong(((Map<String, Object>) stringObjectMap.get("sign")).get("doc_count").toString()));
            warningStat.setNoFeedback(Long.parseLong(((Map<String, Object>) stringObjectMap.get("feedback")).get("doc_count").toString()));
            warningStat.setHistoryStatistics(Long.parseLong( stringObjectMap.get("doc_count").toString()));
            warningStat.setTodayStatistics(Long.parseLong(((Map<String, Object>) stringObjectMap.get("startTime")).get("doc_count").toString()));
            warningStat.setPlanName(stringObjectMap.get("key").toString());
            warningStatList.add(warningStat);
        }
        return warningStatList;
    }
}
