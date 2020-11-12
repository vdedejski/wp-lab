package mk.finki.ukim.mk.lab.web.servlets;

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

@WebServlet(name = "balloon-size-servlet", urlPatterns = "/SelectBalloonSize")
public class SelectBalloonSizeServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;


    public SelectBalloonSizeServlet(SpringTemplateEngine springTemplateEngine,
                                    BalloonService balloonService,
                                    OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("balloonColor", orderService.getCurrentOrderStatus().getBalloonColor());
        context.setVariable("balloonId", orderService.getCurrentOrderStatus().getBalloonId());

        this.springTemplateEngine.process("selectBalloonSize.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String size = req.getParameter("size");

        orderService.getCurrentOrderStatus().setBalloonSize(size);
        resp.sendRedirect("/BalloonOrder.do");

    }
}
