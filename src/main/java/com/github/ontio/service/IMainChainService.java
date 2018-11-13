package com.github.ontio.service;

import com.github.ontio.paramBean.Result;

public interface IMainChainService {
    Result getMainCurrBlkHeight();
    Result getMainNotifyByBlkHeight(int blkHeight);
    Result getMainNotifyByTxHash(String txhash);
    Result getMainNotify(Integer pageSize, Integer pageNumber);
}
