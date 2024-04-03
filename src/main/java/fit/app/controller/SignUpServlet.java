package fit.app.controller;

import fit.app.utilities.PropertiesLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Log in.
 */
@WebServlet(
        urlPatterns = {"/signUp"}
)
/**
 * Begins the authentication process using AWS Cognito
 *
 */
public class SignUpServlet extends HttpServlet implements PropertiesLoader {
    /**
     * The Properties.
     */
    Properties properties;

    /**
     * The constant CLIENT_ID.
     */
    public static String CLIENT_ID;

    /**
     * The constant SIGNUP_URL.
     */
    public static String SIGNUP_URL;

    /**
     * The constant REDIRECT_URL.
     */
    public static String REDIRECT_URL;

    @Override
    public void init() throws ServletException {
        super.init();
        properties = (Properties) getServletContext().getAttribute("myProperties");
    }

    /**
     * Route to the aws-hosted cognito login page.
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "error.jsp";

        if (properties != null) {
            CLIENT_ID = properties.getProperty("client.id");
            SIGNUP_URL = properties.getProperty("signupURL");
            REDIRECT_URL = properties.getProperty("redirectURL");
            url = SIGNUP_URL + "?response_type=code&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URL;
        }

        resp.sendRedirect(url);
    }
}
