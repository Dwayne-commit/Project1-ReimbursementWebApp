import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Serv.SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        String reason=request.getParameter("reason");
        String amount=request.getParameter("amount");
        String status=request.getParameter("status");
        int role = Integer.parseInt(request.getParameter("role"));

        Emp e=new Emp();
        e.setName(name);
        e.setPassword(password);
        e.setEmail(email);
        e.setCountry(country);
        e.setReason(reason);
        e.setAmount(amount);
        e.setStatus(status);
        e.setRole(role);

        int statuss= EmpDao.save(e);
        if(statuss>0){
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        }else{
            out.println("Sorry! unable to save record");
        }

        out.close();
    }

}
