package by.htp.les04.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.les04.controller.CheckAuthorisationSession;
import by.htp.les04.controller.command.Command;
import by.htp.les04.service.NewsService;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.ServiceProvider;
import static by.htp.les04.controller.command.impl.ControllerLevelConstant.*;

public class SaveEdittedInformation implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {

		if (CheckAuthorisationSession.redirectIfNotAuthorisated(request, response)) {
			return;
		}

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();

		String idStr = request.getParameter(ID_PARAM);
		int idInt = Integer.parseInt(idStr);
		String title = request.getParameter(TITLE_PARAM);
		String brief = request.getParameter(BRIEF_PARAM);
		String content = request.getParameter(CONTENT_PARAM);

		newsService.updateNews(idInt, title, brief, content); 

		response.sendRedirect(REDIRECT_FROM_SAVE_EDDITED_INFORMATION_TO_GO_TO_FULL_NEWS_PAGE + idInt);
	}
}
