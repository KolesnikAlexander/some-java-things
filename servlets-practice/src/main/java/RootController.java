/**
 * Created by alex60070 on 18.07.17.
 */

import java.io.*;
        import javax.servlet.*;
        import javax.servlet.http.*;

    public class RootController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        String kukuParam = request.getParameter("kuku");
        String attribute = (String) request.getAttribute("attr1");

        // Set the response MIME type of the response message
        response.setContentType("text/html");
        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();

        // Write the response message, in an HTML page
        try {
            out.println("+Request uri: "+request.getRequestURI());
            out.println("+Context Path: "+request.getContextPath());
            out.println("<html>");
            out.println("<head><title>Hello, World</title></head>");
            out.println("<body>");


            out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
            out.println("<p>+Context Path: "+request.getContextPath()+"<p>");
            out.println("<p>+Servlet path: "+String.valueOf(request.getServletPath())+"<p>");
            out.println("<p>+Path info: "+String.valueOf(request.getPathInfo())+"<p>");

            out.println("<h1>Hello, world!</h1>");  // says Hello
            // Echo client's request information
            out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
            out.println("+Context Path: "+request.getContextPath());
            out.println("+Path info: "+String.valueOf(request.getPathInfo()));
            out.println("<p>Protocol: " + request.getProtocol() + "</p>");
            out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
            out.println("+Query string: "+String.valueOf(request.getQueryString()));
            out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
            // Generate a random number upon each request
            out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
            out.println("HELLO!");
            if(kukuParam != null)
                out.println("Kuku is set: \""+kukuParam+"\"");

            out.println("</body></html>");


        } finally {
            out.close();  // Always close the output writer
        }
    }
}
