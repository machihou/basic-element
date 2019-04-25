package cn.boommanpro.cache.config.multi;

import lombok.Data;

import java.io.Serializable;

@Data
public class CacheMessage implements Serializable {

    private static final long serialVersionUID = 5987219310442078193L;

    private String cacheName;

    private Object key;

    private Integer sender;

    public CacheMessage(String cacheName, Object key) {
        super();
        this.cacheName = cacheName;
        this.key = key;
    }

    public CacheMessage(String cacheName, Object key, Integer sender) {
        super();
        this.cacheName = cacheName;
        this.key = key;
        this.sender = sender;
    }

}