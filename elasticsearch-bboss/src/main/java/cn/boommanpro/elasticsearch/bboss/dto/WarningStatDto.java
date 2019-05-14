package cn.boommanpro.elasticsearch.bboss.dto;

import lombok.Data;

@Data
public class WarningStatDto {
    private Long todayStatistics;
    private Long historyStatistics;
    private Long noSign;
    private Long noFeedback;
    private String planName;
}
