package com.example.lotto.plan.mapper;

import com.example.lotto.plan.model.LottoPlan;
import org.apache.ibatis.annotations.*;

/**
 * @author ZhangGR
 * @created on 2018/9/16
 **/
@Mapper
public interface LottoPlanMapper {

    /**
     * 新增一条当日计划
     * @param lottoPlan
     */
    @Insert("insert into tbl_lotto_ssc_plan (type, name, date, data, latest) values (#{type}, #{name}, #{date}, #{data}, #{latest})")
    void save(LottoPlan lottoPlan);

    /**
     * 更新当日计划
     * @param lottoPlan
     */
    @Update("update tbl_lotto_ssc_plan set data=#{data}, latest=#{latest} where id=#{id}")
    void update(LottoPlan lottoPlan);

    /**
     * 查询当日计划
     * @param type
     * @param date
     * @return
     */
    @Select("select * from tbl_lotto_ssc_plan where type = #{type} and date = #{date} order by id desc limit 1")
    LottoPlan select(@Param("type")Integer type, @Param("date")String date);
}
