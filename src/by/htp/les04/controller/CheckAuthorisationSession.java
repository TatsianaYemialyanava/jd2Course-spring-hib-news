package by.htp.les04.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckAuthorisationSession {
	public static final String REDIRECT_FROM_CHECK_AUTHORISATION_SESSION_TO_INDEX_PAGE_IF_NEED_LOGIN = 
			"Conrtoller?command=gotoindexpage&message=You need to log in";
	public static final String AUTH = "auth";
	public static final String REDIRECT_FROM_CHECK_AUTHORISATION_SESSION_TO_INDEX_PAGE_IF_USER_NOT_AUTHORISED = 
			"Controller?command=gotoindexpage&message=Authorization is required to work on the site";

	public static boolean redirectIfNotAuthorisated(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Boolean result = false;

		HttpSession session = request.getSession();
		if(session == null) {
			response.sendRedirect(REDIRECT_FROM_CHECK_AUTHORISATION_SESSION_TO_INDEX_PAGE_IF_NEED_LOGIN);
			result = true;
		}

		Boolean isAuth = (Boolean)session.getAttribute(AUTH);
		if(isAuth == null || !isAuth) {
			response.sendRedirect(REDIRECT_FROM_CHECK_AUTHORISATION_SESSION_TO_INDEX_PAGE_IF_USER_NOT_AUTHORISED);
			result = true;
		}
		return result;
	}
}


