package cn.boommanpro.elasticsearch.bboss.model;


import com.frameworkset.orm.annotation.ESId;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangqimeng
 */
@Data
public class Warnings implements Serializable {


    private static final long serialVersionUID = -7184334287397890579L;

    @ESId
    private String id;

    private String planName;

    private String startTime;

    private Integer sign;

    private Integer feedbackDiscovery;

    /**
     * 监督者 多值
     */
    private List<String> supervisor;


}
