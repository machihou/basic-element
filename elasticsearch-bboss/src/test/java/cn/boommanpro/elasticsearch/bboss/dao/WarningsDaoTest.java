package cn.boommanpro.elasticsearch.bboss.dao;

import cn.boommanpro.elasticsearch.bboss.dto.WarningStatDto;
import cn.boommanpro.elasticsearch.bboss.model.Warnings;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class WarningsDaoTest {
    @Autowired
    private WarningsDao warningsDao;

    @Test
    public void save() {

        for (int i = 0; i < 10000; i++) {
            Warnings warnings = new Warnings();
            warnings.setId(UUID.randomUUID().toString());
            warnings.setPlanName("测试计划"+new Random().nextInt(3));
            warnings.setSign(new Random().nextInt(3));
            warnings.setFeedbackDiscovery(new Random().nextInt(3));
            warnings.setStartTime(new Date().getTime()+"");
            warnings.setSupervisor(Lists.newArrayList("boomman","boommanpro"));
            warningsDao.save(warnings);
        }

    }

    @Test
    public void queryWarningStat() {
        List<String> planNames = new ArrayList<>();

        planNames.add("测试计划1");
        planNames.add("测试计划0");
        List<WarningStatDto> warningStatDtoList = warningsDao.queryWarningStat(planNames);
        log.debug("queryResult:{}",warningStatDtoList);
    }
}