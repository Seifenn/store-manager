package admin;

public class Worker extends Person {
    private String username;
    private String password;
    private int cin;
    private float salary;
    private int empid;

    public int getEmpid() {
        return empid;
    }

    public Worker(String name, String lastname, String username, String password, int cin, float salary, int empid) {
        super(name, lastname);
        this.username = username;
        this.password = password;
        this.cin = cin;
        this.salary = salary;
        this.empid = empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public Worker(String name, String lastname, String username, String password, int cin, float salary) {
        super(name, lastname);
        this.username = username;
        this.password = password;
        this.cin = cin;
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
