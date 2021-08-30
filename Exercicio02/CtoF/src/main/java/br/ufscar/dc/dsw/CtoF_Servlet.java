package br.ufscar.dc.dsw;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/CtoF_Servlet" })
public class CtoF_Servlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response, String metodo)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CtoF_Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            
            String minVal = request.getParameter("minVal");
			int min = (minVal == null || minVal.isEmpty()) ? -100 : Integer.parseInt(minVal);

			String maxVal = request.getParameter("maxVal");
			int max = (maxVal == null || maxVal.isEmpty()) ? 100 : Integer.parseInt(maxVal);

			String incVal = request.getParameter("incVal");
			int inc = (incVal == null || incVal.isEmpty()) ? 5 : Integer.parseInt(incVal);
            
			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>Celsius</th>");
			out.println("<th>Fahrenheit</th>");
			out.println("</tr>");
			for (int celsius = min; celsius <= max; celsius += inc) {
				double fahr = 1.8 * celsius + 32;
				out.println("<tr>");
				out.println("<td>" + celsius + "</td>");
				out.println("<td>" + fahr + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "GET");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "POST");
    }
}
