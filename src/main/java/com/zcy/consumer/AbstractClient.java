package com.zcy.consumer;


import com.zcy.common.UserService;
import com.zcy.domain.Page;
import com.zcy.domain.User;
import com.zcy.provider.UserServiceServerImpl;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author PC
 */
public abstract class AbstractClient {
	private final AtomicInteger counter = new AtomicInteger(0);
	private final UserService _serviceUserService = new UserServiceServerImpl();

	protected abstract UserService getUserService();

	public boolean existUser() throws Exception {
		String email = String.valueOf(counter.getAndIncrement());
		return getUserService().existUser(email);
	}

	public boolean createUser() throws Exception {
		int id = counter.getAndIncrement();
		User user = _serviceUserService.getUser(id);
		return getUserService().createUser(user);
	}

	public User getUser() throws Exception {
		int id = counter.getAndIncrement();
		return getUserService().getUser(id);
	}

	public Page<User> listUser() throws Exception {
		int pageNo = counter.getAndIncrement();
		return getUserService().listUser(pageNo);
	}

}
