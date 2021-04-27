package by.htp.les04.dao.impl;

public interface DAOLevelConstant {
	String URL = "jdbc:mysql://127.0.0.1/news_management_hib?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	String USER = "root"; 
	String PASSWORD = "7105713)#TA";
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	String ID_PARAM = "id";
	String TITLE = "title";
	String BRIEF = "brief";
	String CONTENT = "content";
	String DATE = "date";
	String USER_NAME = "user_name";
	String USER_SURNAME = "user_surname";
	String USER_LOGIN = "login";
	String USER_EMAIL = "email";
	String USER_ROLE = "role";
	String TAKE_ALL_NEWS = "SELECT * FROM news WHERE status = 'active'";
	String TAKE_ONE_NEWS_TEMPLATE = "SELECT * FROM news WHERE id = %d";
	String UPDATE_NEWS_TEMPLATE = "UPDATE news SET title = '%s', brief = '%s', content = '%s' WHERE id = %d";
	String DELETE_NEWS_TEMPLATE = "UPDATE news SET status = 'not active' WHERE id = %d";
	String AUTORIZATION_USER_TEMPLATE = "SELECT * FROM users WHERE login = '%s' AND password = '%s'";
	String CREATE_USER_TEMPLATE = "INSERT INTO users (user_name, user_surname, email, login, password, role) VALUES ('%s', '%s', '%s','%s','%s', 'user')";
}
