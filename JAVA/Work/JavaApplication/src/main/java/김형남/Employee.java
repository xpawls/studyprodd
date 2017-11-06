package 김형남;

public class Employee {
    private   String name;
    private   String addr;
    protected int    salary;
    private   String rnn;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
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
    public Employee(String name, String addr, int salary, String rnn) {
        super();
        this.name = name;
        this.addr = addr;
        this.salary = salary;
        this.rnn = rnn;
    }
    public Employee() {
        super();
    }
    @Override
    public String toString() {
        return "Employee [name=" + name + ", addr=" + addr + ", salary="
                + salary + ", rnn=" + rnn + "]";
    }
    
    
}
