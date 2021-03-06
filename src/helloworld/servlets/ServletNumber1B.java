package helloworld.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletNumber1B extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
     public void init(ServletConfig config) throws ServletException {            /*#2*/
         super.init(config);
         this.message = config.getInitParameter("message");                      /*#3*/
     }
     
     public void doGet(HttpServletRequest request, HttpServletResponse response) /*#4*/
     throws IOException, ServletException
      {
         ServletContext servletContext = getServletConfig().getServletContext();
         //servletContext.setAttribute("foo","bar");
         String foo = (String) servletContext.getAttribute("foo");
         
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();                                 /*#5*/
          out.println("<html>");
          out.println("<head>");
          out.println("<title>" + this.message + "</title>");                     /*#6*/
          out.println("</head>");
          out.println("<body>");
          out.println("<h1>Hello World!</h1>");
          out.println("session attrib is " + foo);
          out.println("</body>");
          out.println("</html>");
      }
}
