package java14.stexemployee;

public class Employee {
    
    // 필드
    private String name    = "";
    private String address = "";
    protected int salary   = 0;
    private String rnn     = "";
    
    // get set
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getRnn() {
        return rnn;
    }
    public void setRnn(String rnn) {
        this.rnn = rnn;
    }
    
    // toString
    @Override
    public String toString() {
        return "Employee [name=" + name + ", address=" + address + ", salary="
                + salary + ", rnn=" + rnn + "]";
    }
    
    // constructor
    public Employee(String name, String address, int salary, String rnn) {
        super();
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.rnn = rnn;
    }
    public Employee() {
        super();
    }
    
    
}
