package by.htp.les04.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.htp.les04.dao.impl.SQLNewsDAO;
import by.htp.les04.dao.impl.SQLUserDAO;

@Component
public final class DAOProvider {
	
	public static final DAOProvider instance = new DAOProvider();
	
	private final UserDAO userDAO = new SQLUserDAO();
	
	private static NewsDAO newsDAO;
	
	@Autowired
	public void temporaryInit(NewsDAO newsDAO) {
		System.out.println("Spring configured NewsDAO for DAOProvider");
		DAOProvider.newsDAO = newsDAO;
	}
	
	private DAOProvider() {
	}
	
	public static DAOProvider getInstance() {
		return instance;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public NewsDAO getNewsDAO() {
		return newsDAO;
	}
}