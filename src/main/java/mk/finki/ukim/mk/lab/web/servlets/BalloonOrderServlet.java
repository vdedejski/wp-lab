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

@WebServlet(name = "balloon-order-servlet", urlPatterns = "/BalloonOrder.do")
public class BalloonOrderServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;


    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine,
                               BalloonService balloonService,
                               OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

        req.getSession().setAttribute("size", orderService.getCurrentOrderStatus().getBalloonSize());

        context.setVariable("balloonId", orderService.getCurrentOrderStatus().getBalloonId());
        context.setVariable("balloonSize", orderService.getCurrentOrderStatus().getBalloonSize());
        this.springTemplateEngine.process("deliveryInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");

        orderService.getCurrentOrderStatus().setClientNameAndAddress(clientName, clientAddress);

        resp.sendRedirect("/ConfirmationInfo");
    }
}
