import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Serv.LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web", "root", "root");
            String n = request.getParameter("txtName");
            String p = request.getParameter("txtPwd");
            PreparedStatement ps = con.prepareStatement("select role from login where name=? and password=?");
            ps.setString(1, n);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int role = rs.getInt(1);
            if (role == 1) {
                // manager
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            } else if(role > 1){
                RequestDispatcher rd = request.getRequestDispatcher("emp.jsp");
                rd.forward(request, response);
            }else {
                // employee
                out.println("<font color=red size=18>Login Failed!!<br>");
                out.println("<a href=index.jsp>TRY AGAIN!!</a>");
            }
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}

