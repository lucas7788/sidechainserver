package com.github.ontio.controller;

import com.github.ontio.paramBean.Result;
import com.github.ontio.service.impl.MainChainServiceImpl;
import com.github.ontio.service.impl.SideChainServiceImpl;
import com.github.ontio.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/v1/sidechain")
public class SideChainController {
    private static final Logger logger = LoggerFactory.getLogger(CommitPosController.class);

    private final String CLASS_NAME = this.getClass().getSimpleName();

    private static final String VERSION = "1.0";

    @Autowired
    private SideChainServiceImpl sideChainService;

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/getblkheight", method = RequestMethod.GET)
    @ResponseBody
    public Result getMainBlkHeight() {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = sideChainService.getSideCurrBlkHeight();
        return rs;
    }

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/getnotifybyheight/{height}", method = RequestMethod.GET)
    @ResponseBody
    public Result getMainBlkHeight(@PathVariable("height") int height) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = sideChainService.getSideNotifyByBlkHeight(height);
        return rs;
    }

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/getnotifybytxhash/{txhash}", method = RequestMethod.GET)
    @ResponseBody
    public Result getNotifyByTxhash(@PathVariable("txhash") String txhash) {
        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        Result rs = sideChainService.getSideNotifyByTxHash(txhash);
        return rs;
    }


    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/getnotifyall", method = RequestMethod.GET)
    @ResponseBody
    public Result getMainNotifyAll() {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = sideChainService.getSideNotifyAll();
        return rs;
    }
}
