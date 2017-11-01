package test;

public class PhoneInfo {
    String name;
    String phoneNumber;
    String birthday;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public PhoneInfo(String name, String phoneNumber, String birthday) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }
    public PhoneInfo(String name, String phoneNumber) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public PhoneInfo() {
        super();
    }
    
    
    
}
