package cn.boommanpro.dao;

import cn.boommanpro.model.RowResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RowResourceMapper extends BaseMapper<RowResource> {
    RowResource findByFullName(String fullName);
}