package com.github.ontio.service;

import com.github.ontio.paramBean.Result;

public interface ISendTxService {
    Result getSendTx(Integer pageSize, Integer pageNumber);
    Result getSendTxByTxhash(String txhash);
    Result getSendTxDetail(Integer pageSize, Integer pageNumber);
    Result getsendTxDetailByTxhash(String txhash);
}
