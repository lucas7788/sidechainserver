package com.github.ontio.service;

import com.github.ontio.paramBean.Result;

public interface ISideChainService {
    Result getSideCurrBlkHeight();
    Result getSideNotifyByBlkHeight(int blkHeight);
    Result getSideNotifyByTxHash(String txhash);
    Result getSideNotifyAll();
}
