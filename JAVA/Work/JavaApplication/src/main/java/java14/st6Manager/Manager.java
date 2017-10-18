package java14.st6Manager;

public class Manager extends Employee {
    
    // 필드
    private int bonus = 0;
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bonus;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Manager other = (Manager) obj;
        if (bonus != other.bonus)
            return false;
        return true;
    }


    // constructor
    public Manager(String name, String address, int salary, String rnn,
            int bonus) {
        super(name, address, salary, rnn);
        this.bonus = bonus;
    }
    

    public Manager(int bonus) {
        super();
        this.bonus = bonus;
    }

    public Manager() {
        super();
    }

    public Manager(String name, String address, int salary, String rnn) {
        super(name, address, salary, rnn);
    }
    
    

    @Override
    public String toString() {
        return "Manager [bonus=" + bonus + ", toString()=" + super.toString()
                + "]";
    }

    public void test(){
        System.out.println(this.toString());
        
        String info = "name : " + super.getName();
        info = info + ", address : " + super.getAddress();
        info = info + ", salary : " + super.salary;
        info = info + ", rrn : " + super.getRnn();
        System.out.println(info);
    }
}
