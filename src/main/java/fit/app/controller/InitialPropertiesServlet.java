package fit.app.controller;

import fit.app.utilities.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;


/**
 * The type Initial properties servlet.
 */
@WebServlet(
        urlPatterns = {"/initialProperties"},
        loadOnStartup = 1
)
public class InitialPropertiesServlet extends HttpServlet implements PropertiesLoader {
    /**
     * The constant PROPERTIES_FILE.
     */
    public static final String PROPERTIES_FILE = "/cognito.properties";

    @Override
    public void init() throws ServletException {
        Properties properties = null;

        properties = loadProperties(PROPERTIES_FILE);

        getServletContext().setAttribute("myProperties", properties);
    }

    /**
     * This method forwards the request to the "addHealthRecord.jsp" page, setting attributes
     * for the title and stylesheet.
     *
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while handling the request
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/settings");
        dispatcher.forward(req, resp);
    }
}
