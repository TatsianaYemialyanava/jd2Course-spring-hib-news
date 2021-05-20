package by.htp.les04.controller.command.spring;

import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Component
	public class GlobalExceptionHandler extends SimpleMappingExceptionResolver {
	private static Logger logger = LogManager.getLogger();
	
	@Override
    protected ModelAndView doResolveException(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName(REDIRECT_PREFIX + REDIRECT_TO_ERROR_PAGE);
	    modelAndView.addObject("message", ex.getMessage());
	    logger.info("# exception occured #" + ex.getMessage());
	    return modelAndView;
    }
}
