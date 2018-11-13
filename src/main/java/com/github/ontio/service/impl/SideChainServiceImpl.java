package com.github.ontio.service.impl;

import com.github.ontio.dao.BlkHeightMainMapper;
import com.github.ontio.dao.BlkHeightSideMapper;
import com.github.ontio.dao.NotifyMapper;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.ISideChainService;
import com.github.ontio.utils.ErrorInfo;
import com.github.ontio.utils.Helper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("SideChainService")
@MapperScan("com.github.ontio.dao")
public class SideChainServiceImpl implements ISideChainService {
    private static final String VERSION = "1.0";

    @Autowired
    BlkHeightSideMapper blkHeightSideMapper;

    @Autowired
    NotifyMapper notifyMapper;

    @Override
    public Result getSideCurrBlkHeight() {
        int height = blkHeightSideMapper.selectDBHeight();
        Map<String, Object> rs = new HashMap<>();
        rs.put("sideblkheight", height);
        return Helper.result("getsideblkheight", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getSideNotifyByBlkHeight(int blkHeight) {
        List<Map> res = notifyMapper.selectSideNotifyByHeight(blkHeight);
        Map<String, Object> rs = new HashMap<>();
        rs.put("SideChainNotify", res);
        return Helper.result("getsidenotifybyheight", ErrorInfo.SUCCESS.code(), ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getSideNotifyByTxHash(String txhash) {

        List<Map> res = notifyMapper.selectSideNotifyByTxhash(txhash);
        Map<String, Object> rs = new HashMap<>();
        rs.put("SideChainNotify", res);
        return Helper.result("getsidenotifybyhash", ErrorInfo.SUCCESS.code(), ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }

    @Override
    public Result getSideNotify(Integer pageSize, Integer pageNumber) {
        int start = pageSize * (pageNumber - 1) < 0 ? 0 : pageSize * (pageNumber - 1);
        List<Map> res = notifyMapper.selectSideNotifyByPage(start, pageSize);
        Map<String, Object> rs = new HashMap<>();
        rs.put("SideChainNotify", res);
        return Helper.result("getsidenotifybypage", ErrorInfo.SUCCESS.code(), ErrorInfo.SUCCESS.desc(),
                VERSION,rs);
    }
}
