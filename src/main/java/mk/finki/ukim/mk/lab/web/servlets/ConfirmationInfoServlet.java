package mk.finki.ukim.mk.lab.web.servlets;

import mk.finki.ukim.mk.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "confirmation-info-servlet", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

//        context.setVariable("clientName", orderService.getCurrentOrderStatus().getUser().getAddress());
//        context.setVariable("clientAddress", orderService.getCurrentOrderStatus().getUser().getUsername());
        context.setVariable("clientIP", req.getRemoteAddr());
        context.setVariable("clientBrowser", req.getHeader("user-agent"));
//        context.setVariable("balloonColor", orderService.getCurrentOrderStatus().getBalloonColor());
//        context.setVariable("balloonSize", orderService.getCurrentOrderStatus().getBalloonSize());
//        context.setVariable("balloonId", orderService.getCurrentOrderStatus().getBalloonId());


        this.springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/balloons");
    }
}
