package by.htp.les04.controller.command.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.htp.les04.bean.User;
import by.htp.les04.controller.command.Command;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.ServiceProvider;
import by.htp.les04.service.UserService;
import static by.htp.les04.controller.command.impl.ControllerLevelConstant.*;

public class Logination implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
		String login; 
		String password;

		login = request.getParameter(LOGIN_PARAM);
		password = request.getParameter(PASSWORD_PARAM);

		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		User user = null;
		try {

			user = userService.authorization(login, password);
			if(user == null) {
				response.sendRedirect(REDIRECT_FROM_LOGINATION_TO_INDEX_PAGE);
				return;
			}

			HttpSession session = request.getSession(true);
			session.setAttribute(AUTH_ATTRIBUTE, true);
			session.setAttribute(NAME_ATTRIBUTE, user.getName());
			session.setAttribute(ROLE_ATTRIBUTE, user.getRole());	
			response.sendRedirect(REDIRECT_FROM_LOGINATION_TO_GO_TO_MAIN_PAGE);
		}catch(ServiceException e) {
			response.sendRedirect(REDIRECT_FROM_LOGINATION_PAGE_IN_EXCEPTION_CASE + e.getMessage());
		}
	}
}