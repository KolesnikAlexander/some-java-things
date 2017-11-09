package view;

import entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by alex60070 on 28.07.17.
 */
public class ProductView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            Product product = (Product) req.getAttribute("product");
            resp.setContentType("text/html");
            if (product == null){
                out.println("<p>No such product</p>");
            }
            else {
                out.println("<p>Product information: </p>");
                out.println("<p>"+product.getId()+"</p>");
                out.println("<p>"+product.getName()+"</p>");
                out.println("<p>"+product.getModel()+"</p>");

            }
        }finally {
            out.close();
        }
    }
}
