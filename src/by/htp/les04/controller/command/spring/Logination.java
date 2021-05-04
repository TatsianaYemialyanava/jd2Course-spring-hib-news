package by.htp.les04.controller.command.spring;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.User;
import by.htp.les04.controller.command.Command;
import by.htp.les04.service.NewsService;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.ServiceProvider;
import by.htp.les04.service.UserService;
import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/Controller")
public class Logination{
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private HttpSession session;
	
	@RequestMapping(params = {"command=logination"})
	public String execute(@ModelAttribute("user") User user, Model theModel) throws ServletException, IOException, ServiceException {
		
		String login = user.getLogin();
		String password = user.getPassword();
		
		user = null;
		try {

			user = userService.authorization(login, password);
			
			if(user == null) {
				theModel.addAttribute("message", "user not registrated");
				return "redirect:" + REDIRECT_FROM_LOGINATION_TO_INDEX_PAGE;
			}
			session.setAttribute(AUTH_ATTRIBUTE, true);
			session.setAttribute(NAME_ATTRIBUTE, user.getName());
			session.setAttribute(ROLE_ATTRIBUTE, user.getRole());
			return REDIRECT_PREFIX + REDIRECT_FROM_LOGINATION_TO_GO_TO_MAIN_PAGE;
		}catch(ServiceException e) {
			theModel.addAttribute("message", e.getMessage() );
			return REDIRECT_PREFIX + REDIRECT_FROM_LOGINATION_PAGE_IN_EXCEPTION_CASE;
		}
	}
}

/*@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("loginData") LoginData loginData) {

		// log the input data
		System.out.println("data: " + loginData.getLogin() + " " + loginData.getPassword());

		return "main-page";
	}*/

