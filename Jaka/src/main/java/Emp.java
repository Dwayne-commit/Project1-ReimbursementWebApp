public class Emp {
    private int id;
    private int role;
    private String name,password,email,country,reason,amount,status;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getReason(){return reason;}
    public void setReason(String reason) {this.reason = reason;}
    public String getAmount(){return amount;}
    public void setAmount(String amount){this.amount = amount;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status = status;}

    public int getRole(){return role;}
    public void setRole(int role){this.role = role;}
}
