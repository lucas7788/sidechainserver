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


package com.github.ontio;

import com.github.ontio.utils.ConfigParam;
import com.github.ontio.utils.ConstantParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleCORSFilter implements Filter {

	@Autowired
	ConfigParam configParam;


	public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
		initParam();
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		String origin = request.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Origin", origin);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods",
				"POST, PUT, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader(
				"Access-Control-Allow-Headers",
				"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

	public void initParam(){
		ConstantParam.MAINCHAIN_RPC_URL = configParam.MAINCHAIN_RPC_URL;
		ConstantParam.ADMIN_ADDRESS = configParam.ADMIN_ADDRESS;
		ConstantParam.ADMIN_PASSWORD = configParam.ADMIN_PASSWORD;
		ConstantParam.ADMIN_WALLET = configParam.ADMIN_WALLET;
		ConstantParam.SDK = OntSdk.getInstance();
		ConstantParam.SDK.openWalletFile(ConstantParam.ADMIN_WALLET);
		try {
			ConstantParam.ADMIN = ConstantParam.SDK.getWalletMgr().getAccount(ConstantParam.ADMIN_ADDRESS,ConstantParam.ADMIN_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConstantParam.SDK.setRpc(ConstantParam.MAINCHAIN_RPC_URL);
	}

}