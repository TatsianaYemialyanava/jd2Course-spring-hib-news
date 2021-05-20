package by.htp.les04.controller.command.spring;

public interface ControllerLevelConstant {
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
	String MESSAGE = "message";
	String USER = "user";
	
	//PATHS
	String CONTROLLER_PATH = "Controller?";
	
	String REDIRECT_FROM_DELETE_NEWS_TO_MAIN_PAGE = "Controller?command=gotomainpage";
	String REDIRECT_FROM_LOGINATION_TO_GO_TO_MAIN_PAGE = "Controller?command=gotomainpage";
	String REDIRECT_FROM_LOGINATION_PAGE_IN_EXCEPTION_CASE = "Controller?command=gotomainpage";
	String REDIRECT_FROM_LOGOUT_TO_GO_TO_INDEX_PAGE = "AnonymousController?command=gotoindexpage";	
	String REDIRECT_FROM_SAVE_NEW_USER_TO_GO_TO_INDEX_PAGE = "AnonymousController?command=gotoindexpage";
	String REDIRECT_FROM_LOGINATION_TO_INDEX_PAGE = "AnonymousController?command=gotoindexpage"; 
	String REDIRECT_FROM_SAVE_NEW_USER_TO_REGISTRATION_PAGE = "AnonymousController?command=registration";
	String REDIRECT_FROM_SAVE_EDDITED_INFORMATION_TO_GO_TO_FULL_NEWS_PAGE = "Controller?command=go_to_full_news_page&id=";
	String REDIRECT_TO_ERROR_PAGE = "AnonymousController?command=go_to_error_page";

	String REQUESTDISPATCHER_FROM_GO_TO_EDIT_PAGE_TO_EDIT_PAGE = "edit_page";
	String REQUESTDISPATCHER_FROM_GO_TO_ERROR_PAGE_TO_ERROR_PAGE = "error_page";
	String REQUESTDISPATCHER_FROM_GO_TO_FULL_NEWS_PAGE_TO_FUII_NEWS_PAGE = "full_news_page";
	String REQUESTDISPATCHER_FROM_GO_TO_INDEX_PAGE_TO_MAIN_INDEX = "main_index";
	String REQUESTDISPATCHER_FROM_GO_TO_MAIN_PAGE_TO_MAIN = "main";
	String REQUESTDISPATCHER_FROM_GO_TO_REGISTRATION_PAGE_TO_REGISTRATION = "registration";
	String  REDIRECT_PREFIX = "redirect:";	
}
