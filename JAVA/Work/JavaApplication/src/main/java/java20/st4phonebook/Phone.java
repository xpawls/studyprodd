package java20.st4phonebook;

public class Phone {
    
    protected String addr = "";
    protected String number = "";
    
    public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Phone(String addr, String number) {
        super();
        this.addr = addr;
        this.number = number;
    }

    public Phone() {
        super();
    }
    
    
}
