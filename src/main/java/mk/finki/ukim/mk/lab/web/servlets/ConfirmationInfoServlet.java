package mk.finki.ukim.mk.lab.web.servlets;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.service.BalloonService;
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
    private final BalloonService balloonService;
    private final OrderService orderService;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine,
                                   BalloonService balloonService,
                                   OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.balloonService = balloonService;
        this.orderService = orderService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("clientName", orderService.getCurrentOrderStatus().getClientName());
        context.setVariable("clientAddress", orderService.getCurrentOrderStatus().getClientAddress());
        context.setVariable("clientIP", req.getRemoteAddr());
        context.setVariable("clientBrowser", req.getHeader("user-agent"));
        context.setVariable("balloonColor", orderService.getCurrentOrderStatus().getBalloonColor());
        context.setVariable("balloonSize", orderService.getCurrentOrderStatus().getBalloonSize());

        this.springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataHolder.orderList.add(orderService.getCurrentOrderStatus());

        req.getSession().invalidate();
        orderService.getCurrentOrderStatus().dumpData();
        resp.sendRedirect("/general");
    }
}
