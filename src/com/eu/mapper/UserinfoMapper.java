package com.eu.mapper;

import com.eu.pojo.Userinfo;
import com.eu.pojo.UserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserinfoMapper {
    int countByExample(UserinfoExample example);

    int deleteByExample(UserinfoExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    List<Userinfo> selectByExample(UserinfoExample example);

    Userinfo selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByExample(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    // 自己添加的接口
    List<Userinfo> selectByPrimaryKeyList(List<Long> uidlist);

    //UPDATE userinfo set reputation = reputation - 5 WHERE uid in (15061884292,15061881234)

    void deductReputation(List<Long> uidlist);

    void increaseReputation(List<Long> uidlist);

}