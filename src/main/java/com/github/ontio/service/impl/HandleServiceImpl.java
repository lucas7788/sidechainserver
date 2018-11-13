package com.github.ontio.service.impl;

import com.github.ontio.network.exception.ConnectorException;
import com.github.ontio.paramBean.Result;
import com.github.ontio.service.IHandleService;
import com.github.ontio.utils.ConstantParam;
import com.github.ontio.utils.ErrorInfo;
import com.github.ontio.utils.Helper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service("HandleService")
@MapperScan("com.github.ontio.dao")
public class HandleServiceImpl implements IHandleService {
    private static final String VERSION = "1.0";
    @Override
    public Result getSideChainData() {
        Result result = new Result();
        try {
            String sideChainData = ConstantParam.SDK.getConnect().getSideChainData("123456");
            Map<String, Object> rs = new HashMap<>();
            rs.put("sideChainData", sideChainData);
            return Helper.result("getsidechaindata", ErrorInfo.SUCCESS.code(),ErrorInfo.SUCCESS.desc(),
                    VERSION,rs);
        } catch (ConnectorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
