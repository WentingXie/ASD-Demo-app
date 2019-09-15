package asd.demo.service;

import asd.demo.model.User;

public interface IUserService {

	User loginUser(String email, String userPwd);

	int registUser(User user);

	int updateUserInfo(User user);

	User getUser(String email);

}
