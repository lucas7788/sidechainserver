package com.github.ontio.dao;

import com.github.ontio.model.MsgInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "SendTxMsgInfoMapper")
public interface SendTxMsgInfoMapper {
    int insert(MsgInfo info);
    Map selectSendTxByHash(String txhash);
    List<Map> selectSendTxByPage(Integer start, Integer pageSize);
}
