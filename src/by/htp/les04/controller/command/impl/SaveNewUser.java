package by.htp.les04.controller.command.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp.les04.bean.User;
import by.htp.les04.controller.command.Command;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.ServiceProvider;
import by.htp.les04.service.UserService;
import static by.htp.les04.controller.command.impl.ControllerLevelConstant.*;

public class SaveNewUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
		try {
			String userName = request.getParameter(NAME_PARAM);
			String userSurname = request.getParameter(SURNAME_PARAM);
			String userEmail = request.getParameter(EMAIL_PARAM);
			String userLogin = request.getParameter(LOGIN_PARAM);
			String userPassword = request.getParameter(PASSWORD_PARAM);

			User userInfo = new User();
			userInfo.setName(userName);
			userInfo.setSurname(userSurname);
			userInfo.setEmail(userEmail);
			userInfo.setLogin(userLogin);
			userInfo.setPassword(userPassword);

			System.out.println(userInfo.toString());

			ServiceProvider provider = ServiceProvider.getInstance();
			UserService userService = provider.getUserService();

			userService.createUser(userInfo);

			response.sendRedirect(REDIRECT_FROM_SAVE_NEW_USER_TO_GO_TO_INDEX_PAGE);
		} catch (ServiceException e) {
			response.sendRedirect(REDIRECT_FROM_SAVE_NEW_USER_TO_REGISTRATION_PAGE + e.getMessage());		
		}
	}
}

