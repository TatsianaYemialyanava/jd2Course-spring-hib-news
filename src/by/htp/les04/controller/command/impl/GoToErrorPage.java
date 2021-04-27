package by.htp.les04.controller.command.impl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp.les04.controller.command.Command;
import by.htp.les04.service.ServiceException;
import static by.htp.les04.controller.command.impl.ControllerLevelConstant.*;

public class GoToErrorPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ServiceException {
		
		RequestDispatcher requesrDispatcher = request.getRequestDispatcher(REQUESTDISPATCHER_FROM_GO_TO_ERROR_PAGE_TO_ERROR_PAGE);
		requesrDispatcher.forward(request, response);
	}
}
