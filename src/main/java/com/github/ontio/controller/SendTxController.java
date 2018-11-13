package com.github.ontio.controller;


import com.github.ontio.paramBean.Result;
import com.github.ontio.service.impl.SendTxServiceImpl;
import com.github.ontio.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/v1/sendtx")
public class SendTxController {
    private static final Logger logger = LoggerFactory.getLogger(CommitPosController.class);

    private final String CLASS_NAME = this.getClass().getSimpleName();

    private static final String VERSION = "1.0";

    @Autowired
    private SendTxServiceImpl sendTxService;

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/getsendtxbyhash/{txhash}", method = RequestMethod.GET)
    @ResponseBody
    public Result getSendTxByTxhash(@PathVariable("txhash") String txhash) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = sendTxService.getSendTxByTxhash(txhash);
        return rs;
    }

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/getsendtx/{pagesize}/{pagenumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getSendTx(@PathVariable("pagenumber") Integer pageNumber,
                            @PathVariable("pagesize") Integer pageSize) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        logger.info("pageSize:{}, pageNumber；{}", pageSize, pageNumber);

        Result rs = sendTxService.getSendTx(pageSize, pageNumber);
        return rs;
    }

    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/getsendtxdetailbyhash/{txhash}", method = RequestMethod.GET)
    @ResponseBody
    public Result getsendTxDetailByTxhash(@PathVariable("txhash") String txhash) {
        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());
        Result rs = sendTxService.getsendTxDetailByTxhash(txhash);
        return rs;
    }


    /**
     *
     *
     * @return
     */
    @RequestMapping(value = "/getsendtxdetail/{pagesize}/{pagenumber}", method = RequestMethod.GET)
    @ResponseBody
    public Result getMainNotifyAll(@PathVariable("pagenumber") Integer pageNumber,
                                   @PathVariable("pagesize") Integer pageSize) {

        logger.info("########{}.{} begin...", CLASS_NAME, Helper.currentMethod());

        Result rs = sendTxService.getSendTxDetail(pageSize, pageNumber);
        return rs;
    }
}
