package by.htp.les04.controller.command.impl;

interface ControllerLevelConstant {
	//PARAMS
	String ID_PARAM = "id";
	String LANGUAGE_PARAM = "language";
	String COMMAND_REDIRECT_PARAM = "commandRedirect";
	String LOGIN_PARAM = "login";
	String PASSWORD_PARAM = "password";
	String NAME_PARAM = "name";
	String SURNAME_PARAM = "surname";
	String EMAIL_PARAM = "email";
	String TITLE_PARAM = "title";
	String BRIEF_PARAM = "brief";
	String CONTENT_PARAM = "content";
	
	//ATTRIBUTES
	String SINGLE_NEWS_ATTRIBUTE = "singleNews";
	String NEWS_ATTRIBUTE = "news";
	String TWO_LETTERS_LANGUAGE_ATTRIBUTE = "twoLettersLanguage";
	String AUTH_ATTRIBUTE = "auth";
	String NAME_ATTRIBUTE = "name";
	String ROLE_ATTRIBUTE = "role";
	
	//PATHS
	String CONTROLLER_PATH = "Controller?";
	
	String REDIRECT_FROM_DELETE_NEWS_TO_MAIN_PAGE = "Controller?command=gotomainpage&message=News was deleted";
	String REDIRECT_FROM_LOGINATION_TO_GO_TO_MAIN_PAGE = "Controller?command=gotomainpage";
	String REDIRECT_FROM_LOGINATION_PAGE_IN_EXCEPTION_CASE = "Controller?command=gotomainpage&message=";
	
	String REDIRECT_FROM_LOGOUT_TO_GO_TO_INDEX_PAGE = "Controller?command=gotoindexpage&message=logout OK";
	String REDIRECT_FROM_SAVE_NEW_USER_TO_GO_TO_INDEX_PAGE = "Controller?command=gotoindexpage&message=Registration completed successfully";
	String REDIRECT_FROM_LOGINATION_TO_INDEX_PAGE = "Controller?command=gotoindexpage&message=this user not registrated";
	
	String REDIRECT_FROM_SAVE_NEW_USER_TO_REGISTRATION_PAGE = "Controller?command=registration&message=";
	
	String REDIRECT_FROM_SAVE_EDDITED_INFORMATION_TO_GO_TO_FULL_NEWS_PAGE = "Controller?command=go_to_full_news_page&message=news has been saved&id=";
	String REDIRECT_TO_ERROR_PAGE = "Controller?command=go_to_error_page&message=An error has occurred. Wait a while and try again";
	
	String REQUESTDISPATCHER_FROM_GO_TO_EDIT_PAGE_TO_EDIT_PAGE = "/WEB-INF/jsp/edit_page.jsp";
	String REQUESTDISPATCHER_FROM_GO_TO_ERROR_PAGE_TO_ERROR_PAGE = "/WEB-INF/jsp/error_page.jsp";
	String REQUESTDISPATCHER_FROM_GO_TO_FULL_NEWS_PAGE_TO_FUII_NEWS_PAGE = "/WEB-INF/jsp/full_news_page.jsp";
	String REQUESTDISPATCHER_FROM_GO_TO_INDEX_PAGE_TO_MAIN_INDEX = "/WEB-INF/jsp/main_index.jsp";
	String REQUESTDISPATCHER_FROM_GO_TO_MAIN_PAGE_TO_MAIN = "/WEB-INF/jsp/main.jsp";
	String REQUESTDISPATCHER_FROM_GO_TO_REGISTRATION_PAGE_TO_REGISTRATION = "/WEB-INF/jsp/registration.jsp";
		
}
