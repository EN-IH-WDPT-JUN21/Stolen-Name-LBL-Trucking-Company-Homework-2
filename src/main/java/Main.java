
public class Main {

    public static MainMenu nathan = new MainMenu("Nathan");
    //public static Login login = new Login(); Temporarily disabled during development

    public static void main(String[] args) {
        //login.login();  Temporarily disabled during development
        nathan.newLead();


        //System.out.println(MainMenu.theLeads.get("0").toString()); Replaced in MainMenu instead

        nathan.convertLead(MainMenu.theLeads.get("1").getId());


        nathan.createAccount(MainMenu.theContacts.get("3"), MainMenu.theOpportunities.get("2"));

        System.out.println(MainMenu.theContacts.get("3").toString());
        System.out.println(MainMenu.theOpportunities.get("2").toString());
        System.out.println(MainMenu.theAccounts.get("4").toString());

    }
}
