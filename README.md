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
```

* /api/v1/sidechain/getnotifybytxhash/{txhash}

Query notify of side chain by transaction hash

* /api/v1/sidechain/getnotifybypage/{pagesize}/{pagenumber}

Query notify by page

### event handle result api list

* /api/v1/sendtx/getsendtxbyhash/{txhash}

Query transaction by txhash




* /api/v1/sendtx/getsendtx/{pagesize}/{pagenumber}

Query transaction by page

* /api/v1/sendtx/getsendtxdetailbyhash/{txhash}

Query transaction detail by transaction hash

* /api/v1/sendtx/getsendtxdetail/{pagesize}/{pagenumber}

Query transaction detail by page