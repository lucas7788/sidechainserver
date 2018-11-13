package com.github.ontio.dao;

import com.github.ontio.model.NotifyInfoDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Mapper
@Component(value = "NotifyMapper")
public interface NotifyMapper {
    int insertMainNotify(NotifyInfoDao info);
    int insertSideNotify(NotifyInfoDao info);

    Map selectMainNotifyByHeight(Integer height);
    Map selectMainNotifyByTxhash(String txhash);
    Map selectMainNotify(Integer pageSize, Integer pageNumber);

    Map selectSideNotifyByHeight(Integer height);
    Map selectSideNotifyByTxhash(String txhash);
    Map selectSideNotify(Integer pageSize, Integer pageNumber);
}
