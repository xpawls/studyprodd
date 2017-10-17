package java14.stexemployee;

public class Manager extends Employee {
    
    // 필드
    private int bonus = 0;
    
    // constroctor
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
        System.out.println(this.getName());
        System.out.println(this.getAddress());
        System.out.println(this.getSalary());
        System.out.println(this.getRnn());
    }
}
