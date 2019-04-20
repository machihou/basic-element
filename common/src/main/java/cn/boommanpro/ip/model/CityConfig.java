package cn.boommanpro.ip.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@RequiredArgsConstructor(staticName = "of")
public class CityConfig {
    /**
     * 城市策略 0为自动识别  1为全部一线城市  2为全部二线城市
     */
    private Integer cityStrategy;

    private String hotCities;
}
