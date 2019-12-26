package base.comm.intercepter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BaseInterceptor extends HandlerInterceptorAdapter {
	
	protected Logger log = LogManager.getLogger(BaseInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            log.debug("======================================          PRE START         ======================================");
            log.debug(" Request URI \t:  " + request.getRequestURI());
            log.debug("###### parameter ######");
            Enumeration<?> en = request.getParameterNames();
            while(en.hasMoreElements()) {
            	String paramKey = (String) en.nextElement();            	
            	log.debug("key : " + paramKey +";value="+request.getParameter(paramKey));
            }
/**
            log.debug("###### Attribute ######");
    		Enumeration<?> attrNames = request.getAttributeNames();
    		while (attrNames.hasMoreElements()) {
    			String attrName = (String) attrNames.nextElement();
            	log.debug("key : " + attrName +";value="+request.getAttribute(attrName));

    		}
*/
            log.debug("###### Header ######");
    		Enumeration<?> headerNames = request.getHeaderNames();
    		while (headerNames.hasMoreElements()) {
    			String headerName = (String) headerNames.nextElement();
            	log.debug("key : " + headerName +";value="+request.getAttribute(headerName));

    		}
    		
    		log.debug("###### session ######");
    		Enumeration<?> sessNames = request.getSession().getAttributeNames();
    		while (sessNames.hasMoreElements()) {
    			String sessName = (String) sessNames.nextElement();
            	log.debug("key : " + sessName +";value="+request.getSession().getAttribute(sessName));
    		}
    		log.debug("======================================          PRE END         ======================================");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("======================================           POST END          ======================================\n");
        }
    }
}
