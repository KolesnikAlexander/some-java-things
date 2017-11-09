package controller;

import entity.Product;
import model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by alex60070 on 27.07.17.
 */
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            String name = req.getParameter("name");
            if (name == null) {
                out.println("Choose product type");
            }
            else if (name.equals("")){
                out.println("Empty input");
            }
            else{
                ProductModel model = new ProductModel();
                Product product = model.getProduct(name);
                    req.setAttribute("product", product);
                    req.getRequestDispatcher("/view/product/productView").forward(req, resp);
            }
        }
        finally {
           out.close();
        }



    }
}
