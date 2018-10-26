import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MainServlet extends HttpServlet {

    private final ArrayList<UserData> usersList;

    public MainServlet(ArrayList<UserData> usersList) {
        this.usersList = usersList;

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String src = request.getParameter("src");
        String dst = request.getParameter("dst");
        long summ = Long.parseLong(request.getParameter("summ"));

        Transaction transaction = new Transaction(usersList, src, dst, summ);
        transaction.transfer();
        String report = transaction.viewAll();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(report);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
