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
        //Получаем параметры из запроса
        String src = request.getParameter("src");
        String dst = request.getParameter("dst");
        long summ = Long.parseLong(request.getParameter("summ"));
        //Выполняем перевод
        Transaction transaction = new Transaction(clientList);
        boolean report = transaction.transfer(src, dst, summ);
        response.setContentType("text/html;charset=utf-8");
        if (report) {
            response.getWriter().println("Операция выполнена");
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.getWriter().println("Операция не выполнена");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
