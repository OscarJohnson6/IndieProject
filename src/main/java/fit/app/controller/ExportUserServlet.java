package fit.app.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fit.app.database.GenericDao;
import fit.app.entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


/**
 * A simple servlet.
 *
 * Code from: <a href="https://mkyong.com/java/how-to-download-file-from-website-java-jsp/">Mkyong article</a>
 *
 * @author OscarJohnson6
 */
@WebServlet(
        urlPatterns = {"/infoExport"}
)
public class ExportUserServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This method forwards the request to the "/settings" servlet,
     * after printing a json file of the current user account to the client
     *
     * @param req  the http request object representing the client's request
     * @param resp the http response object representing the servlet's response
     * @throws ServletException if the servlet encounters difficulty while handling the request
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition","attachment;filename=healthInfo.json");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        User user = (User) req.getSession().getAttribute("userAccount");

        try {
            String userJsonString = objectMapper.writeValueAsString(user);
            ServletOutputStream out = resp.getOutputStream();

            InputStream in =
                    new ByteArrayInputStream(userJsonString.getBytes(StandardCharsets.UTF_8));

            byte[] outputByte = new byte[4096];
            while (in.read(outputByte, 0, 4096) != -1) {
                out.write(outputByte, 0, 4096);
            }
            in.close();
            out.flush();
            out.close();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error downloading/making json file", jsonProcessingException);
        } catch (IOException ioException) {
            logger.error("Error writing json file ", ioException);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/settings");
        dispatcher.forward(req, resp);
    }
}
