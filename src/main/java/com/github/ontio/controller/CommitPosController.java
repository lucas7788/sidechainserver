package com.github.ontio.controller;


import com.github.ontio.paramBean.Result;
import com.github.ontio.service.impl.HandleServiceImpl;
import com.github.ontio.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/v1/commitdpos")
public class CommitPosController {
    private static final Logger logger = LoggerFactory.getLogger(CommitPosController.class);

    private final String CLASS_NAME = this.getClass().getSimpleName();

    private static final String VERSION = "1.0";

    @Autowired
    private HandleServiceImpl handleService;


    /**
     * query the last few blocks
     *
     * @return
     */
    @RequestMapping(value = "/getsidechaindata", method = RequestMethod.GET)
    @ResponseBody
    public Result querySideChainData() {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = handleService.getSideChainData();
        return rs;
    }
}
