package by.htp.les04.controller.command.spring;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/Controller")
public class Logout {
	
	@Autowired 
	private HttpSession session;
	
	@RequestMapping(params = {"command=logout"})
	public String execute(Model theModel) throws ServletException, IOException {
		
		if(session != null) {
			session.removeAttribute(AUTH_ATTRIBUTE);
		}
		
		theModel.addAttribute(MESSAGE, "logout OK");

		return REDIRECT_PREFIX + REDIRECT_FROM_LOGOUT_TO_GO_TO_INDEX_PAGE;
	}
}
