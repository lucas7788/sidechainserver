package com.github.ontio.dao;


import com.github.ontio.model.NotifyInfoDao;
import com.github.ontio.model.SendTxDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "SendTxDetailMapper")
public interface SendTxDetailMapper {
    int insertSendTxDetail(SendTxDetail info);
    int updateSendTxDetail(String txhash);
    List<Map> selectSendTxDetailByHash(String txhash);
    List<Map> selectSendTxDetailByPage(Integer start, Integer pageSize);
}
