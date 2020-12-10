package mk.finki.ukim.mk.lab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class StepOverFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String color = (String) request.getSession().getAttribute("color");
        String user = (String) request.getSession().getAttribute("username");

        String path = request.getServletPath();
        System.out.println(path);
//        if (user == null && !"/balloons".equals(path) && !"/".equals(path)) {
//            response.sendRedirect("/login");
//        }

        if ((color == null && !"/balloons".equals(path) && !"/main.css".equals(path)
                && !"/form".equals(path) && !"/balloons/add".equals(path)
                && !path.contains("/balloons/delete/") && !path.contains("/balloons/edit-balloon/")
                && !"/search".equals(path) && !"/searchByType".equals(path)
                && !"/login".equals(path) && !"/register".equals(path))) {
            response.sendRedirect("/balloons");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
