package asd.demo.model.dao;

import asd.demo.model.User;

public interface IUserDao {

	User findByEmailAndPwd(String email, String userPwd);

	User findByEmail(String email);

	int insertUser(User user);

	int updateUserInfo(User user);
}
