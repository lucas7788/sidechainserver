package com.github.ontio.controller;


import com.github.ontio.paramBean.Result;
import com.github.ontio.service.impl.MainChainServiceImpl;
import com.github.ontio.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/v1/mainchain")
public class MainChainController {

    private static final Logger logger = LoggerFactory.getLogger(CommitPosController.class);

    private final String CLASS_NAME = this.getClass().getSimpleName();

    private static final String VERSION = "1.0";

    @Autowired
    private MainChainServiceImpl mainChainService;

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/getblkheight", method = RequestMethod.GET)
    @ResponseBody
    public Result getMainBlkHeight() {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = mainChainService.getMainCurrBlkHeight();
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

        Result rs = mainChainService.getMainNotifyByBlkHeight(height);
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
        Result rs = mainChainService.getMainNotifyByTxHash(txhash);
        return rs;
    }


    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/getnotifybypage/{pagesize}/{pagenumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getMainNotify(@PathVariable("pagenumber") Integer pageNumber,
                                @PathVariable("pagesize") Integer pageSize) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = mainChainService.getMainNotify(pageSize, pageNumber);
        return rs;
    }
}
