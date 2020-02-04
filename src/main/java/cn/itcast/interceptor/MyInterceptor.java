package cn.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {

    //预处理，controller方法执行前
    //return true放行，执行下一个拦截器，如果没有，执行controller中的方法
    //return flase
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        if(session.getAttribute("user")==null){
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return false;
        }
        return true;
    }

    /**
     * 后处理方法，controller方法执行后，success.jsp执行前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后处理执行");
        //若在此设置跳转，controller中的跳转无效
    }

    /**
     * success.jsp执行后，执行此方法，最后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("最后");
        //无法设置跳转页面，可以设置释放资源
    }
}
