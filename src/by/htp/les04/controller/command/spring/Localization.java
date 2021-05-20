package by.htp.les04.controller.command.spring;

import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping(value={"/AnonymousController","/Controller","/AdminController"})
public class Localization {
	
	@RequestMapping(params = {"command=localization"})

	public String execute(@RequestParam("commandRedirect") String commandForRedirect) throws ServletException, IOException {
		
		return REDIRECT_PREFIX + commandForRedirect;
	}
}
