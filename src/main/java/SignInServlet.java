import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignInServlet extends HttpServlet {

    private SomethingLikeSessionBase base = new SomethingLikeSessionBase();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter write = resp.getWriter();

        ServletContext servletContext = getServletConfig().getServletContext();

        String user = req.getParameter("userName");
        String pass = req.getParameter("userPass");
        req.setAttribute("userName", user);
        if (base.userExist(user)) {
            if (base.passCorrect(user, pass)) {
                RequestDispatcher rd = req.getRequestDispatcher("mypage.jsp");
                rd.forward(req, resp);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("incorrectPasswordSignIn.jsp");
                rd.forward(req, resp);
            }
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("failedSignIn.jsp");
            rd.forward(req, resp);
        }
    }
}