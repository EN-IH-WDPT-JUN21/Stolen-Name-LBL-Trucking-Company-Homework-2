//For creating basic Leads. Extends Client information in order to retain a unique ID counter.

import java.util.Scanner;

public class Lead extends ClientInformation {

    protected String name;
    protected String phoneNumber;
    protected String email;
    protected String companyName;
    private static Scanner scanner = new Scanner(System.in);

    public Lead() {
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public String getId() {
        return id;
    }


    public String toString() {
        return "name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", companyName='" + getCompanyName() + '\'' +
                '}';
    }

}


