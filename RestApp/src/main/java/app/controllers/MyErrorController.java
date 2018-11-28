package app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
/**
 * Basic global error {@link Controller}, rendering {@link ErrorAttributes}. More specific
 * errors can be handled either using Spring MVC abstractions (e.g.
 * {@code @ExceptionHandler}) or by adding servlet
 * {@link AbstractEmbeddedServletContainerFactory#setErrorPages container error pages}.
 *
 * @author Dave Syer
 * @author Phillip Webb
 * @see ErrorAttributes
 */
@Controller
public class MyErrorController implements ErrorController {

	@Value("${error.path:/error}")
	private String errorPath;

	 
	 

	@Override
	public String getErrorPath() {
		return this.errorPath;
	}

	@RequestMapping(value = "${error.path:/error}", produces = "text/html")
	public ModelAndView errorHtml(HttpServletRequest request) {
		 HttpStatus status = getStatus(request);
		return new ModelAndView("errr",  "msg" , status.name()+":"+status.value());
	}

	@RequestMapping(value = "${error.path:/error}")
	@ResponseBody
	public String error(HttpServletRequest request) {
		 HttpStatus status = getStatus(request);
		return ""+status.name() ;
	}

	private boolean getTraceParameter(HttpServletRequest request) {
		String parameter = request.getParameter("trace");
		if (parameter == null) {
			return false;
		}
		return !"false".equals(parameter.toLowerCase());
	}

	 

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request
				.getAttribute("javax.servlet.error.status_code");
		if (statusCode != null) {
			try {
				return HttpStatus.valueOf(statusCode);
			}
			catch (Exception ex) {
			}
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

}