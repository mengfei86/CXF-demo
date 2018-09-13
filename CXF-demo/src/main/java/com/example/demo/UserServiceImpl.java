package com.example.demo;

import javax.jws.WebService;

@WebService(targetNamespace="http://service.demo.paybay.cn/",endpointInterface = "com.example.demo.UserService")
public class UserServiceImpl implements UserService {

	@Override
	public String getName(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
