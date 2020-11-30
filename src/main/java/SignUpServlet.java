import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignUpServlet extends HttpServlet {

    private SomethingLikeSessionBase base = new SomethingLikeSessionBase();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter write = resp.getWriter();

        ServletContext servletContext = getServletConfig().getServletContext();

        String user = req.getParameter("userName");
        if (user == null){
            throw new ServletException();
        }
        String pass = req.getParameter("userPass");
        if (pass == null){
            throw new ServletException();
        }
        req.setAttribute("userName", user);
        if (base.userExist(user)) {
            RequestDispatcher rd = req.getRequestDispatcher("failedRegistration.jsp");
            rd.forward(req, resp);
        } else {
            base.addUser(user,pass);
            RequestDispatcher rd = req.getRequestDispatcher("successRegistration.jsp");
            rd.forward(req, resp);
        }
    }
}