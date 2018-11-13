package com.github.ontio.service;

import com.github.ontio.paramBean.Result;

public interface ISendTxService {
    Result getSendTxByPage(Integer pageSize, Integer pageNumber);
    Result getSendTxByTxhash(String txhash);
    Result getSendTxDetailByPage(Integer pageSize, Integer pageNumber);
    Result getsendTxDetailByTxhash(String txhash);
}
