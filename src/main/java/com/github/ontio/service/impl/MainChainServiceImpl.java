package com.github.ontio.service.impl;

import com.github.ontio.dao.BlkHeightMainMapper;
import com.github.ontio.dao.NotifyMapper;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.IMainChainService;
import com.github.ontio.utils.ConstantParam;
import com.github.ontio.utils.ErrorInfo;
import com.github.ontio.utils.Helper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("MainChainService")
@MapperScan("com.github.ontio.dao")
public class MainChainServiceImpl implements IMainChainService {

    private static final String VERSION = "1.0";

    @Autowired
    private BlkHeightMainMapper blkHeightMainMapper;

    @Autowired
    private NotifyMapper notifyMapper;

    @Override
    public Result getMainCurrBlkHeight() {
        Integer height = blkHeightMainMapper.selectDBHeight();
        Map<String, Object> rs = new HashMap<>();
        rs.put("blkheight", height);
        return Helper.result("getblkheight", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getMainNotifyByBlkHeight(int blkHeight) {
        List<Map> res = notifyMapper.selectMainNotifyByHeight(blkHeight);
        Map<String, Object> rs = new HashMap<>();
        rs.put("MainChainNotify", res);
        return Helper.result("getmainnotifybyheight", ErrorInfo.SUCCESS.code(), ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getMainNotifyByTxHash(String txhash) {

        List<Map> res = notifyMapper.selectMainNotifyByTxhash(txhash);
        Map<String, Object> rs = new HashMap<>();
        rs.put("MainChainNotify", res);
        return Helper.result("getmainnotifybyhash", ErrorInfo.SUCCESS.code(), ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getMainNotify(Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<Map> res = notifyMapper.selectMainNotifyByPage(start, pageSize);
        Map<String, Object> rs = new HashMap<>();
        rs.put("MainChainNotify", res);
        return Helper.result("getmainnotifybypage", ErrorInfo.SUCCESS.code(), ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }
}
