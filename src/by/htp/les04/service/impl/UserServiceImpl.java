package by.htp.les04.service.impl;

import by.htp.les04.bean.User;
import by.htp.les04.dao.DAOException;
import by.htp.les04.dao.DAOProvider;
import by.htp.les04.dao.UserDAO;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.UserService;
import static by.htp.les04.service.impl.validatorIncomingData.ValidationDataForAuthorisation.*;
import static by.htp.les04.service.impl.validatorIncomingData.ValidationDataForRegistration.*;

public class UserServiceImpl implements UserService {

	@Override
	public User authorization(String login, String password) throws ServiceException {
	
		if (!validateDataForAuthorisation(login, password)) {
			throw new ServiceException("wrong login or password");
		}
		
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();
		
		User user = null;
		try {
			user = userDAO.authorization(login, password);
		}catch (DAOException e) {
			throw new ServiceException (e.getMessage(), e);
		}
		return user;
	}

	

	@Override
	public void createUser(User userInfo) throws ServiceException {
		
		String name = userInfo.getName();
		String surname = userInfo.getSurname();
		String email = userInfo.getEmail();
		String login = userInfo.getEmail();
		String password = userInfo.getPassword();
		
		if (!validateDataForRegistration(name, surname, email, login, password)) {
			throw new ServiceException("incorrect data entered");
		}
				
		DAOProvider provider = DAOProvider.getInstance();
		UserDAO userDAO = provider.getUserDAO();
		
		try {
			
			userDAO.createUser(userInfo);
		}catch (DAOException e) {
			throw new ServiceException (e.getMessage(), e);
		}
		
	}

	
	

}
