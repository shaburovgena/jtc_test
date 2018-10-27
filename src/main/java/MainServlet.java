import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    private final ClientList clientList;

    MainServlet(ClientList clientList) {
        this.clientList = clientList;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String src = request.getParameter("src");
        String dst = request.getParameter("dst");
        long summ = Long.parseLong(request.getParameter("summ"));
        Transaction transaction = new Transaction(clientList);
        String report = transaction.transfer(src, dst, summ);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(report);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
