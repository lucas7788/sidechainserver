/*
 * Copyright (C) 2018 The ontology Authors
 * This file is part of The ontology library.
 *
 * The ontology is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The ontology is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with The ontology.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.github.ontio.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @author zhouq
 * @date 2018/2/27
 */

@Service("ConfigParam")
public class ConfigParam {




    /**
     * ontology blockchain restful url
     */
    @Value("${mainchain.rpc.url}")
    public String MAINCHAIN_RPC_URL;

    @Value("${admin.wallet.file}")
    public String ADMIN_WALLET;

    @Value("${admin.address}")
    public String ADMIN_ADDRESS;

    @Value("${admin.password}")
    public String ADMIN_PASSWORD;

    @Value("${genesisblock.time}")
    public int GENESISBLOCKTIME;

    @Value("${queryAddr.pageSize}")
    public int QUERYADDRINFO_PAGESIZE;



}