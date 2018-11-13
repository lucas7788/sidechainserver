package com.github.ontio.dao;

import com.github.ontio.model.NotifyInfoDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "NotifyMapper")
public interface NotifyMapper {
    int insertMainNotify(NotifyInfoDao info);
    int insertSideNotify(NotifyInfoDao info);

    List<Map> selectMainNotifyByHeight(Integer height);
    List<Map> selectMainNotifyByTxhash(String txhash);
    List<Map> selectMainNotifyByPage(Integer start, Integer pageSize);

    List<Map> selectSideNotifyByHeight(Integer height);
    List<Map> selectSideNotifyByTxhash(String txhash);
    List<Map> selectSideNotifyByPage(Integer start, Integer pageSize);
}
