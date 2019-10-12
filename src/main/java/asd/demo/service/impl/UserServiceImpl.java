package asd.demo.service.impl;

import asd.demo.model.User;
import asd.demo.model.dao.IUserDao;
import asd.demo.model.dao.impl.UserDaoImpl;
import asd.demo.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao = new UserDaoImpl();

	@Override
	public User loginUser(String email, String userPwd) {

		return userDao.findByEmailAndPwd(email, userPwd);
	}

	@Override
	public int registUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public int updateUserInfo(User user) {
		return userDao.updateUserInfo(user);
	}

	@Override
	public User getUser(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User checkUserEmail(String email) {
		return userDao.findByEmailAndPwd(email, null);
	}

}
