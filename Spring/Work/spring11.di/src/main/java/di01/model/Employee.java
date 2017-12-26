package di01.model;

public class Employee {
    private String name;
    private int salary;
    private String address;
    private String rnn;
    
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getRnn() {
        return rnn;
    }


    public void setRnn(String rnn) {
        this.rnn = rnn;
    }


    public Employee() {
        super();
    }
    


    public Employee(String name, int salary, String address, String rnn) {
        super();
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.rnn = rnn;
    }


    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + ", address="
                + address + ", rnn=" + rnn + "]";
    }
    
}