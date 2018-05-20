package com.sadseven.bcdividend.mapper;

import com.sadseven.bcdividend.model.Dividend;
import com.sadseven.bcdividend.model.DividendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DividendMapper {
    long countByExample(DividendExample example);

    int deleteByExample(DividendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dividend record);

    int insertSelective(Dividend record);

    List<Dividend> selectByExample(DividendExample example);

    Dividend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dividend record, @Param("example") DividendExample example);

    int updateByExample(@Param("record") Dividend record, @Param("example") DividendExample example);

    int updateByPrimaryKeySelective(Dividend record);

    int updateByPrimaryKey(Dividend record);
}