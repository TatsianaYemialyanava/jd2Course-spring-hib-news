package by.htp.les04.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.les04.controller.command.Command;
import by.htp.les04.controller.command.CommandProvider;
import by.htp.les04.service.ServiceException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String COMMAND = "command";
	//private static final String REDIRECT_FROM_CONTROLLER_TO_ERROR_PAGE = 

	private final CommandProvider provider = new CommandProvider(); 

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		process(request, response);
	}

	private void process (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String name = request.getParameter(COMMAND);
			Command command = provider.takeCommand(name);

			command.execute(request, response);

		}catch(ServiceException e) {
			e.printStackTrace();
			response.sendRedirect("Controller?command=go_to_error_page&message=" + e.getMessage());		
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("Controller?command=go_to_error_page&message=An error has occurred. Wait a while and try again");		
		} 

	}
}
