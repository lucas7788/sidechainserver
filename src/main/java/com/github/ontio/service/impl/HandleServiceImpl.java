package com.github.ontio.service.impl;

import com.github.ontio.network.exception.ConnectorException;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.IHandleService;
import com.github.ontio.utils.ConstantParam;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service("HandleService")
@MapperScan("com.github.ontio.dao")
public class HandleServiceImpl implements IHandleService {
    @Override
    public Result getSideChainData() {
        Result result = new Result();
        try {
            String sideChainData = ConstantParam.SDK.getConnect().getSideChainData("123456");
            result.Result = sideChainData;
            result.Action = "getSideChainData";
            result.Desc = "success";
            result.Error = (long)0;
            result.Version = "1.0";
            return result;
        } catch (ConnectorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
