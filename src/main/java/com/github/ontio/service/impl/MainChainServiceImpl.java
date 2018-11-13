package com.github.ontio.service.impl;

import com.github.ontio.dao.BlkHeightMainMapper;
import com.github.ontio.dao.NotifyMapper;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.IMainChainService;
import com.github.ontio.utils.ConstantParam;
import com.github.ontio.utils.ErrorInfo;
import com.github.ontio.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service("MainChainService")
public class MainChainServiceImpl implements IMainChainService {

    private static final String VERSION = "1.0";

    @Autowired
    BlkHeightMainMapper blkHeightMainMapper;

    @Autowired
    NotifyMapper notifyMapper;

    @Override
    public Result getMainCurrBlkHeight() {
        int height = blkHeightMainMapper.selectDBHeight();
        Map<String, Object> rs = new HashMap<>();
        rs.put("blkheight", height);
        return Helper.result("getblkheight", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getMainNotifyByBlkHeight(int blkHeight) {
        notifyMapper.selectMainNotifyByHeight(blkHeight);
        return null;
    }

    @Override
    public Result getMainNotifyByTxHash(String txhash) {
        return null;
    }

    @Override
    public Result getMainNotifyAll() {
        return null;
    }
}
