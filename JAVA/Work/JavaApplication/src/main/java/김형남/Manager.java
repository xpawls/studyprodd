package 김형남;

public class Manager extends Employee {
    private int bonus;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, String addr, int salary, String rnn,
            int bonus) {
        super(name, addr, salary, rnn);
        this.bonus = bonus;
    }

    public Manager(int bonus) {
        super();
        this.bonus = bonus;
    }

    public Manager() {
        super();
    }

    public Manager(String name, String addr, int salary, String rnn) {
        super(name, addr, salary, rnn);
    }

    @Override
    public String toString() {
        return "Manager [bonus=" + bonus + ", toString()=" + super.toString()
                + "]";
    }
    
    
}
