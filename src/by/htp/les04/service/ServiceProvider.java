package by.htp.les04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.htp.les04.dao.DAOProvider;
import by.htp.les04.dao.NewsDAO;
import by.htp.les04.service.impl.NewsServiceImpl;
import by.htp.les04.service.impl.UserServiceImpl;

@Component
public final class ServiceProvider {
	
	private static final ServiceProvider instance = new ServiceProvider();
	
	private ServiceProvider() {}
	
	private final UserService userService = new UserServiceImpl();
	
	private static NewsService newsService;
	
	@Autowired
	public void temporaryInit(NewsService newsService) {
		System.out.println("Spring configured NewsSetvice for ServiceProvider");
		ServiceProvider.newsService = newsService;
	}
	
	public static ServiceProvider getInstance() {
		return instance;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	public NewsService getNewsService() {
		return newsService; 
	}

}
