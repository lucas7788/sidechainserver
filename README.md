# sidechainserver

## Introduction
Provide Restful API about notify of main chain and side chain, event handle result.

## Api list

Note: The data queryed by the interface below is stored in the database.


### main chain api list

* /api/v1/mainchain/getblkheight

Query the block height of the main chain that is listening.

Example

request:

```
http://localhost:8585/api/v1/mainchain/getblkheight
```

response:
```json
{"Action":"getblkheight","Error":0,"Desc":"SUCCESS","Version":"1.0","Result":{"blkheight":9903}}
```

* /api/v1/mainchain/getnotifybyheight/{height}

Query notify of main chain by block height

Example

request
```
http://localhost:8585/api/v1/mainchain/getnotifybyheight/9836
```

response
```json
{"Action":"getmainnotifybyheight","Error":0,"Desc":"SUCCESS","Version":"1.0","Result":{"MainChainNotify":[{"blkHeight":9836,"funcName":"ongSwap","amount":"100000000000","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"a92b2c574c30d38f8e3b5c62cd1ccdaa84b9346e5a15bc21fdf34e1daf9226ac","sideChainId":"123456","ContractAddress":"0800000000000000000000000000000000000000"},{"blkHeight":9836,"funcName":"ongSwap","amount":"100000000000","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"a92b2c574c30d38f8e3b5c62cd1ccdaa84b9346e5a15bc21fdf34e1daf9226ac","sideChainId":"123456","ContractAddress":"0800000000000000000000000000000000000000"},{"blkHeight":9836,"funcName":"ongSwap","amount":"100000000000","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"a92b2c574c30d38f8e3b5c62cd1ccdaa84b9346e5a15bc21fdf34e1daf9226ac","sideChainId":"123456","ContractAddress":"0800000000000000000000000000000000000000"}]}}
```

* /api/v1/mainchain/getnotifybytxhash/{txhash}

Query notify of main chain by transaction hash

Example

request
```
http://localhost:8585/api/v1/mainchain/getnotifybytxhash/a92b2c574c30d38f8e3b5c62cd1ccdaa84b9346e5a15bc21fdf34e1daf9226ac
```

response
```json
{"Action":"getmainnotifybyhash","Error":0,"Desc":"SUCCESS","Version":"1.0","Result":{"MainChainNotify":[{"blkHeight":9836,"funcName":"ongSwap","amount":"100000000000","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"a92b2c574c30d38f8e3b5c62cd1ccdaa84b9346e5a15bc21fdf34e1daf9226ac","sideChainId":"123456","ContractAddress":"0800000000000000000000000000000000000000"}]}}
```

* /api/v1/mainchain/getnotifybypage/{pagesize}/{pagenumber}

Query notify by page


request
```$xslt
http://localhost:8585/api/v1/mainchain/getnotifybypage/5/1
```

response
```json
{"Action":"getmainnotifybypage","Error":0,"Desc":"SUCCESS","Version":"1.0","Result":{"MainChainNotify":[{"blkHeight":9836,"funcName":"ongSwap","amount":"100000000000","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"a92b2c574c30d38f8e3b5c62cd1ccdaa84b9346e5a15bc21fdf34e1daf9226ac","sideChainId":"123456","ContractAddress":"0800000000000000000000000000000000000000"},{"blkHeight":9836,"funcName":"ongSwap","amount":"100000000000","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"a92b2c574c30d38f8e3b5c62cd1ccdaa84b9346e5a15bc21fdf34e1daf9226ac","sideChainId":"123456","ContractAddress":"0800000000000000000000000000000000000000"},{"blkHeight":9835,"funcName":"ongSwap","amount":"100000000000","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"b3a7a80c2053002c8df855bf9e4f441b84f78b298bad9e06983fc9da7b550a5d","sideChainId":"123456","ContractAddress":"0800000000000000000000000000000000000000"},{"blkHeight":9834,"funcName":"ongSwap","amount":"100000000000","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"aafbad6a1988042456382c2be2b4a4e51710bb2154a48f78eb51ee5dc169a564","sideChainId":"123456","ContractAddress":"0800000000000000000000000000000000000000"},{"blkHeight":9833,"funcName":"ongSwap","amount":"100000000000","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"9678da9580f633683af4df77e8c7e87f2d3034278ef758e4f8728f0db20a38fc","sideChainId":"123456","ContractAddress":"0800000000000000000000000000000000000000"}]}}
```

### side chain api list

* /api/v1/sidechain/getblkheight

Query the block height of the side chain that is listening.

Example

request:
```
http://localhost:8585/api/v1/sidechain/getblkheight
```
response
```json
{"Action":"getsideblkheight","Error":0,"Desc":"SUCCESS","Version":"1.0","Result":{"sideblkheight":5311}}
```

* /api/v1/sidechain/getnotifybyheight/{height}

Query notify of side chain by block height


Example

request:
```
http://localhost:8585/api/v1/sidechain/getnotifybyheight/36708
```

Response

```json
{"Action":"getsidenotifybyheight","Error":0,"Desc":"SUCCESS","Version":"1.0","Result":{"SideChainNotify":[{"blkHeight":36708,"funcName":"ongSwap","amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"44a3993cfecb1ff0a80ab9f3082fa796d9262da72d913f50c4a0f47309e3bc0f","ContractAddress":"0200000000000000000000000000000000000000"}]}}
```

* /api/v1/sidechain/getnotifybytxhash/{txhash}

Query notify of side chain by transaction hash

Example

request:
```
http://localhost:8585/api/v1/sidechain/getnotifybytxhash/44a3993cfecb1ff0a80ab9f3082fa796d9262da72d913f50c4a0f47309e3bc0f
```

reponse:

```json
{"Action":"getsidenotifybyhash","Error":0,"Desc":"SUCCESS","Version":"1.0","Result":{"SideChainNotify":[{"blkHeight":36708,"funcName":"ongSwap","amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"44a3993cfecb1ff0a80ab9f3082fa796d9262da72d913f50c4a0f47309e3bc0f","ContractAddress":"0200000000000000000000000000000000000000"}]}}
```

* /api/v1/sidechain/getnotifybypage/{pagesize}/{pagenumber}

Query notify by page

Example

request:
```
http://localhost:8585/api/v1/sidechain/getnotifybypage/5/1
```

response
```json
{"Action":"getsidenotifybypage","Error":0,"Desc":"SUCCESS","Version":"1.0","Result":{"SideChainNotify":[{"blkHeight":40260,"funcName":"ongSwap","amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"675b2c23f9c7e2f3405bfa2a7f48a477e6d3a5b1215ffececf38571381715bd1","ContractAddress":"0200000000000000000000000000000000000000"},{"blkHeight":40259,"funcName":"ongSwap","amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"6ddf3039b8d1aa877a3a531e5bb3587fe496b539bc00bc3825a53a2896cd323e","ContractAddress":"0200000000000000000000000000000000000000"},{"blkHeight":40258,"funcName":"ongSwap","amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"883cf3f9054f60de2821bbe7bf6ac519b2fbe2ca85de10cefb45436528de953d","ContractAddress":"0200000000000000000000000000000000000000"},{"blkHeight":40257,"funcName":"ongSwap","amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"17a992ceccab7728090df4ae1b6aeb1b75496e63d864cfcba79b1b793dafec1c","ContractAddress":"0200000000000000000000000000000000000000"},{"blkHeight":40256,"funcName":"ongSwap","amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","TxHash":"9ef84be1826e6f650ba26036dd149ae508f194dcd63b76d90872c60c26c7146d","ContractAddress":"0200000000000000000000000000000000000000"}]}}
```

### event handle result api list

* /api/v1/sendtx/getsendtxbytxhash/{txhash}

Query transaction by txhash

Example

request

```url
http://localhost:8585/api/v1/sendtx/getsendtxbytxhash/5d106bf5f6dc866834323aba3ce153720d691269033658b55ec53386de61457c
```

response



```json
{"Action":"getSendTxByTxhash","Error":0,"Desc":"SUCCESS","Version":"1.0","Result":{"SendTx":{"result":"success","functionName":"ongxSwap","description":"","nodeUrl":"","txhash":"5d106bf5f6dc866834323aba3ce153720d691269033658b55ec53386de61457c"}}}
```



* /api/v1/sendtx/getsendtxbypage/{pagesize}/{pagenumber}

Query transaction by page


Example

request

```url
http://localhost:8585/api/v1/sendtx/getsendtxbypage/5/1
```

response
```json
{"Action":"getSendTxByPage","Error":0,"Desc":"SUCCESS","Version":"1.0","Result":{"SendTxList":[{"result":"success","functionName":"ongxSwap","description":"","nodeUrl":"","txhash":"5d106bf5f6dc866834323aba3ce153720d691269033658b55ec53386de61457c"},{"result":"success","functionName":"ongxSwap","description":"","nodeUrl":"","txhash":"afe3ace36afd2ddb22c6e5f1676149109d0c1fb49aaf9bada529fb526bb164c0"},{"result":"success","functionName":"ongxSwap","description":"","nodeUrl":"","txhash":"89ce8627c62f78ca2f0cd77127460619eaaf26829a5ef0f83207cb0e09855958"},{"result":"success","functionName":"ongxSwap","description":"","nodeUrl":"","txhash":"77ab7c7650015f081a7f5350f93bd38ab4da87199b9f18fd1f61dd81fcb2f970"},{"result":"success","functionName":"ongxSwap","description":"","nodeUrl":"","txhash":"95cd6e60d3c9b23f8f2e917afdef1848278215b232b9d648eb1d818df7867467"}]}}
```

* /api/v1/sendtx/getsendtxdetailbytxhash/{txhash}

Query transaction detail by transaction hash

Example

request
```url
http://localhost:8585/api/v1/sendtx/getsendtxdetailbytxhash/5d106bf5f6dc866834323aba3ce153720d691269033658b55ec53386de61457c
```

response

```json
{"Action":"getsendTxDetailByTxhash","Error":0,"Desc":"SUCCESS","Version":"1.0","Result":{"SendTxDetail":[{"blkHeight":40256,"amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","functionName":"ongSwap","nodeUrl":"","sideChainId":"123456","chainType":"sideChain","txhash":"5d106bf5f6dc866834323aba3ce153720d691269033658b55ec53386de61457c"},{"blkHeight":40257,"amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","functionName":"ongSwap","nodeUrl":"","sideChainId":"123456","chainType":"sideChain","txhash":"5d106bf5f6dc866834323aba3ce153720d691269033658b55ec53386de61457c"},{"blkHeight":40258,"amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","functionName":"ongSwap","nodeUrl":"","sideChainId":"123456","chainType":"sideChain","txhash":"5d106bf5f6dc866834323aba3ce153720d691269033658b55ec53386de61457c"}]}}
```

* /api/v1/sendtx/getsendtxdetailbypage/{pagesize}/{pagenumber}

Query transaction detail by page


Example

request

```url
http://localhost:8585/api/v1/sendtx/getsendtxdetailbypage/5/1
```
response

```json
{"Action":"getSendTxDetailByPage","Error":0,"Desc":"SUCCESS","Version":"1.0","Result":{"SendTxDetail":[{"blkHeight":40258,"amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","functionName":"ongSwap","nodeUrl":"","sideChainId":"123456","chainType":"sideChain","txhash":"5d106bf5f6dc866834323aba3ce153720d691269033658b55ec53386de61457c"},{"blkHeight":40257,"amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","functionName":"ongSwap","nodeUrl":"","sideChainId":"123456","chainType":"sideChain","txhash":"5d106bf5f6dc866834323aba3ce153720d691269033658b55ec53386de61457c"},{"blkHeight":40256,"amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","functionName":"ongSwap","nodeUrl":"","sideChainId":"123456","chainType":"sideChain","txhash":"5d106bf5f6dc866834323aba3ce153720d691269033658b55ec53386de61457c"},{"blkHeight":40223,"amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","functionName":"ongSwap","nodeUrl":"","sideChainId":"123456","chainType":"sideChain","txhash":"afe3ace36afd2ddb22c6e5f1676149109d0c1fb49aaf9bada529fb526bb164c0"},{"blkHeight":40222,"amount":"100","address":"AHX1wzvdw9Yipk7E9MuLY4GGX4Ym9tHeDe","functionName":"ongSwap","nodeUrl":"","sideChainId":"123456","chainType":"sideChain","txhash":"89ce8627c62f78ca2f0cd77127460619eaaf26829a5ef0f83207cb0e09855958"}]}}
```