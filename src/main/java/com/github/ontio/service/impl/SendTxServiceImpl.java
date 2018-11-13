package com.github.ontio.service.impl;

import com.github.ontio.dao.SendTxDetailMapper;
import com.github.ontio.dao.SendTxMsgInfoMapper;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.ISendTxService;
import com.github.ontio.utils.ErrorInfo;
import com.github.ontio.utils.Helper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("SendTxService")
@MapperScan("com.github.ontio.dao")
public class SendTxServiceImpl implements ISendTxService {

    private static final String VERSION = "1.0";

    @Autowired
    SendTxDetailMapper sendTxDetailMapper;

    @Autowired
    SendTxMsgInfoMapper sendTxMsgInfoMapper;


    @Override
    public Result getSendTxByPage(Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<Map> res = sendTxMsgInfoMapper.selectSendTxByPage(start, pageSize);
        Map<String, Object> rs = new HashMap<>();
        rs.put("SendTxList", res);
        return Helper.result("getSendTxByPage", ErrorInfo.SUCCESS.code(), ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getSendTxByTxhash(String txhash) {
        Map res = sendTxMsgInfoMapper.selectSendTxByHash(txhash);
        Map<String, Object> rs = new HashMap<>();
        rs.put("SendTx", res);
        return Helper.result("getSendTxByTxhash", ErrorInfo.SUCCESS.code(), ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getSendTxDetailByPage(Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<Map> res = sendTxDetailMapper.selectSendTxDetailByPage(start, pageSize);
        Map<String, Object> rs = new HashMap<>();
        rs.put("SendTxDetail", res);
        return Helper.result("getSendTxDetailByPage", ErrorInfo.SUCCESS.code(), ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getsendTxDetailByTxhash(String txhash) {
        Map res = sendTxDetailMapper.selectSendTxDetailByHash(txhash);
        Map<String, Object> rs = new HashMap<>();
        rs.put("SendTxDetail", res);
        return Helper.result("getsendTxDetailByTxhash", ErrorInfo.SUCCESS.code(), ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }
}
