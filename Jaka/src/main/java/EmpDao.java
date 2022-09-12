
import java.util.*;
import java.sql.*;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class EmpDao {

    public static Connection getConnection()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","root");
            return con;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    public static int save(Emp e){
        int status=0;
        try{
            Connection con=EmpDao.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into user905(name,password,email,country,reason,amount,status,role) values (?,?,?,?,?,?,?,?)");
            ps.setString(1,e.getName());
            ps.setString(2,e.getPassword());
            ps.setString(3,e.getEmail());
            ps.setString(4,e.getCountry());
            ps.setString(5,e.getReason());
            ps.setString(6,e.getAmount());
            ps.setString(7,e.getStatus());
            ps.setInt(8,e.getRole());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    public static int update(Emp e){
        int status=0;
        try{
            Connection con=EmpDao.getConnection();
            PreparedStatement ps=con.prepareStatement("update user905 set name=?,password=?,email=?,country=?,reason=?,amount=?,status=?,role=? where id=?");
            ps.setString(1,e.getName());
            ps.setString(2,e.getPassword());
            ps.setString(3,e.getEmail());
            ps.setString(4,e.getCountry());
            ps.setString(5,e.getReason());
            ps.setString(6,e.getAmount());
            ps.setString(7,e.getStatus());
            ps.setInt(8,e.getId());
            ps.setInt(9,e.getRole());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    public static int delete(int id){
        int status=0;
        try{
            Connection con=EmpDao.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from user905 where id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }
    public static Emp getEmployeeById(int id){
        Emp e=new Emp();

        try{
            Connection con=EmpDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from user905 where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
                e.setReason(rs.getString(6));
                e.setAmount(rs.getString(7));
                e.setStatus(rs.getString(8));
                e.setRole(rs.getInt(9));
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return e;
    }
    public static List<Emp> getAllEmployees(){
        List<Emp> list=new ArrayList<Emp>();

        try{
            Connection con=EmpDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from user905");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Emp e=new Emp();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
                e.setReason(rs.getString(6));
                e.setAmount(rs.getString(7));
                e.setStatus(rs.getString(8));
                e.setRole(rs.getInt(9));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }

    public static List<Emp> getEmployee(String password){
        List<Emp> lists=new ArrayList<Emp>();

        try{
            Connection con=EmpDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from user905 where password=?");
            ps.setString(1,password);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Emp e=new Emp();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
                e.setReason(rs.getString(6));
                e.setAmount(rs.getString(7));
                e.setStatus(rs.getString(8));
                e.setRole(rs.getInt(9));
                lists.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return lists;
    }

    public static Emp getEmployeeByRole(int role){
        List<Emp> lists = new ArrayList<Emp>();
        Emp e=new Emp();

        try{
            Connection con=EmpDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from user905 where role=?");
            ps.setInt(1,role);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
                e.setReason(rs.getString(6));
                e.setAmount(rs.getString(7));
                e.setStatus(rs.getString(8));
                e.setRole(rs.getInt(9));
                lists.add(e);
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return e;
    }
}
