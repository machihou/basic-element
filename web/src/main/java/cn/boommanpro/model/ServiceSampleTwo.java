package cn.boommanpro.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "service_sample")
public class ServiceSampleTwo {
    @Id
    public String id;
}
