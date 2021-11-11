package com.kozlovskaya.lesson_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FirstServlet", urlPatterns = "/first_servlet")

public class FirstServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);
    private final List<Product> productList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (Product product : productList) {
            resp.getWriter().printf("<h1>" + product + "</h1>");
        }
        resp.getWriter().printf("</body></html>");

    }

    @Override
    public void init() {
        logger.debug("Init");
        for (int i = 1; i < 11; i++) {
            productList.add(new Product(i, "Product_" + i, (int) (Math.random() * 40)));
        }
    }
}