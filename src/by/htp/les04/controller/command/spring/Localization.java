package by.htp.les04.controller.command.spring;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.Language;
import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/Controller")
public class Localization {
	
	@Autowired 
	private HttpSession session;
	
	@RequestMapping(params = {"command=localization"})
	public String execute(@ModelAttribute("Language") Language language) throws ServletException, IOException {
	
		String lang = language.getLanguage();
		String commandForRedirect = language.getCommandRedirect(); 
		
		session.setAttribute(TWO_LETTERS_LANGUAGE_ATTRIBUTE, lang);
		return REDIRECT_PREFIX + CONTROLLER_PATH + commandForRedirect;
	}

}
