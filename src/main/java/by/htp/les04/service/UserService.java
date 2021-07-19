package by.htp.les04.service;

import by.htp.les04.bean.User;

public interface UserService {

	User authorization (String login, String password) throws ServiceException;

	void createUser(User userInfo) throws ServiceException;
}
