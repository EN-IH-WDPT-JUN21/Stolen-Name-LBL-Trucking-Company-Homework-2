//For creating basic Leads. Extends Client information in order to retain a unique ID counter.

public class Lead extends ClientInformation {

    protected String name;
    protected String phoneNumber;
    protected String email;
    protected String companyName;

    private static final String colorMain = "\u001B[33m";
    private static final String colorMainBold = "\033[1;37m";
    private static final String colorTable = "\u001B[32m";
    private static final String colorHeadlineBold = "\033[1;34m";
    private static final String reset = "\u001B[0m";

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
        System.out.printf(String.format("%-1s %-17s %-1s %-50s %-1s %-27s %-1s %-47s %-1s %-50s %-1s \n",
                                        colorMain + "║",
                                        colorHeadlineBold + "ID",
                                        colorMain + "║",
                                        colorHeadlineBold + "Name",
                                        colorMain + "║",
                                        colorHeadlineBold + "Phone Number",
                                        colorMain + "║",
                                        colorHeadlineBold + "Email Address",
                                        colorMain + "║",
                                        colorHeadlineBold + "Company Name",
                                        colorMain + "║\n" +
                                        colorMain + "╠════════════╬═════════════════════════════════════════════╬══════════════════════╬══════════════════════════════════════════╬═════════════════════════════════════════════╣"
                                        + reset));
        return  String.format("%-1s %-15s %-1s %-48s %-1s %-25s %-1s %-45s %-1s %-48s %-1s\n",
                              colorMain + "║",
                              colorTable + getId(),
                              colorMain + "║",
                              colorTable + getName(),
                              colorMain + "║",
                              colorTable + getPhoneNumber(),
                              colorMain + "║",
                              colorTable + getEmail(),
                              colorMain + "║",
                              colorTable + getCompanyName(),
                              colorMain + "║"+ reset);
    }

}


