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

public class DeleteNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {

		if (CheckAuthorisationSession.redirectIfNotAuthorisated(request, response)) {
			return;
		}

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();

		String idStr = request.getParameter(ID_PARAM);
		int id = Integer.parseInt(idStr);
		newsService.deleteNews(id);

		response.sendRedirect(REDIRECT_FROM_DELETE_NEWS_TO_MAIN_PAGE);


	}
}
