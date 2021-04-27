package by.htp.les04.controller.command.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.htp.les04.controller.command.Command;
import static by.htp.les04.controller.command.impl.ControllerLevelConstant.*;

public class Logout implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(session != null) {
			session.removeAttribute(AUTH_ATTRIBUTE);
		}

		response.sendRedirect(REDIRECT_FROM_LOGOUT_TO_GO_TO_INDEX_PAGE);
	
	}
}
