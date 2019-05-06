package cn.boommanpro.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author wangqimeng
 */
@Data
public class ServiceSample {
    @Id
    private Integer serviceId;
    private String status;
    private String creator;
    private Integer department;
    private String supervisor;
}
