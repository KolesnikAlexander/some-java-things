package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by alex60070 on 27.07.17.
 */
public class RequestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        try {
            if((pathInfo!=null)&&(pathInfo.equals("/product"))) {
                out.println("Product");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/product-handling");
                requestDispatcher.forward(req, resp);
            }
            else{
                out.println("Not product");
                out.println("+Path info: "+String.valueOf(req.getPathInfo()));
            }
            out.println("Not finally block");
        }catch (NullPointerException e) {
            out.println("Null pointer exception happened");
            e.printStackTrace(out);

        }
        finally {
            out.println("<p>Finally block<p>");
            out.println("<p>+Path info: "+String.valueOf(req.getPathInfo())+"<p>");
            out.close();
        }

        }
}
