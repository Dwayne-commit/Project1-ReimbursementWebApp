import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

@WebServlet("/Serv.SpecificServlet")
public class SpecificServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Records</h1>");
            int role = Integer.parseInt(request.getParameter("role"));
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from user905 where role=" + role);
            ResultSet rs = ps.executeQuery();

            Emp e = EmpDao.getEmployeeByRole(role);
            if (rs.next()) {
                out.print("<table border='1' width='100%'");
                out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Reason</th><th>Amount</th><th>Status</th><th>Role</th><th>Edit</th><th>Delete</th></tr>");
                    out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getPassword() + "</td><td>" + e.getEmail() + "</td><td>" + e.getCountry() + "</td><td>" + e.getReason() + "</td><td>" + e.getAmount() + "</td><td>" + e.getStatus() + "</td><td>" + e.getRole() + "</td><td><a href='Serv.EditServlet?id=" + e.getId() + "'>edit</a></td><td><a href='Serv.DeleteServlet?id=" + e.getId() + "'>delete</a></td></tr>");
            } else {
                out.print("Sorry record not found!");
            }
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}



