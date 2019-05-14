package cn.boommanpro.elasticsearch.bboss;

import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticsearchBbossApplication.class)
public class BBossESStarterTestCase {
    @Autowired
    private BBossESStarter bbossESStarter;


    @Test
    public void testBbossESStarter() throws Exception {
        System.out.println(bbossESStarter);

        //验证环境,获取es状态
        String response = bbossESStarter.getRestClient().executeHttp("_cluster/state?pretty", ClientInterface.HTTP_GET);

        System.out.println(response);

        //判断索引类型是否存在，false表示不存在，正常返回true表示存在
        boolean exist = bbossESStarter.getRestClient().existIndiceType("monitor","warning");

        //判读索引是否存在，false表示不存在，正常返回true表示存在
        exist =  bbossESStarter.getRestClient().existIndice("monitor");

        exist =  bbossESStarter.getRestClient().existIndice("service_sample");

    }

}