import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewServlet extends HttpServlet {
    private final ClientList clientList;

    ViewServlet(ClientList clientList) {
        this.clientList = clientList;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String report = clientList.viewAll();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(report);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
