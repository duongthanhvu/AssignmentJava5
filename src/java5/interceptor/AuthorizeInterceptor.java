package java5.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class AuthorizeInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
		Cookie[] listCookies = request.getCookies();
        if(listCookies != null){
            for(int i = 0; i < listCookies.length; i++){
                if(listCookies[i].getName().equals("quyen")){
                    if(listCookies[i].getValue().equals("admin")) {
                    	return true;
                    }
                }
            }
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/accessdenied.html");
        dispatcher.forward(request, response);
		return false;
	}
}
