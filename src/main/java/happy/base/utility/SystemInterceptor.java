package happy.base.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SystemInterceptor extends HandlerInterceptorAdapter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 后台session控制
		String[] noFilters = new String[] { "login.jsp", "login", "timeout" };
		String uri = request.getRequestURI();

		boolean beFilter = true;
		for (String s : noFilters) {
			if (uri.indexOf(s) != -1) {
				beFilter = false;
				break;
			}
		}

//		if (beFilter) {
//			Object obj = request.getSession().getAttribute("adCdOfDivision");
//			if (obj == null) {
//				request.getRequestDispatcher("/login.jsp").forward(request,
//						response);
//				return false;
//			}
//
//		}

		return super.preHandle(request, response, handler);
	}

}
