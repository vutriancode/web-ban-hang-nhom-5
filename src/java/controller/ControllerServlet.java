
package controller;


import bll.ProductBll;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerServlet",
            loadOnStartup = 1,
            urlPatterns = {"ControllerServlet"})
public class ControllerServlet extends HttpServlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        
        ProductBll productBLL = new ProductBll();
        try {
            getServletContext().setAttribute("newProduct", productBLL.getNewProducts(20));
        } catch (NamingException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
