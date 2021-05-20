package by.htp.les04.dao;

import by.htp.les04.bean.User;

public interface UserDAO {

	User authorization (String login, String password) throws DAOException;

	User loadUser (String login) throws DAOException;

	void createUser(User userInfo) throws DAOException;
}
