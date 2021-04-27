 package by.htp.les04.controller.command.impl;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp.les04.controller.command.Command;
import static by.htp.les04.controller.command.impl.ControllerLevelConstant.*;


public class GoToRegistrationPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			RequestDispatcher requesrDispatcher = request.getRequestDispatcher(REQUESTDISPATCHER_FROM_GO_TO_REGISTRATION_PAGE_TO_REGISTRATION);
			requesrDispatcher.forward(request, response);
	}
}
