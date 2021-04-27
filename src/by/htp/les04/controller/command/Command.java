package by.htp.les04.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.les04.service.ServiceException;

public interface Command {
	
	void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ServiceException;

}
