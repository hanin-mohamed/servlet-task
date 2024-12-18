package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.example.ProductServlet.products;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");

        if (name != null && !name.isEmpty()) {

            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    out.println("<p> " + product.getName() + "    $" + product.getPrice() + "</p>");
                    return;
                }
            }
            out.println("<p>No product found with the name: " + name + "</p>");
        }
    }

}
