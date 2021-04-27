package by.htp.les04.controller.command.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp.les04.controller.command.Command;
import static by.htp.les04.controller.command.impl.ControllerLevelConstant.*;

public class Localization implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String language = request.getParameter(LANGUAGE_PARAM);
		String commandForRedirect = request.getParameter(COMMAND_REDIRECT_PARAM); 
		
		request.getSession(true).setAttribute(TWO_LETTERS_LANGUAGE_ATTRIBUTE, language);
		response.sendRedirect(CONTROLLER_PATH + commandForRedirect);

	}

}
