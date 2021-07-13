
public class Main {

    public static SalesAssociate nathan = new SalesAssociate("Nathan");

    public static void main(String[] args) {

        nathan.newLead();

        System.out.println(Lead.theLeads.get("0").toString());

        nathan.convertLead(Lead.theLeads.get("0"));


        nathan.createAccount(Contact.theContacts.get("0"), Opportunity.theOpportunities.get("0"));

        System.out.println(Contact.theContacts.get("0").toString());
        System.out.println(Opportunity.theOpportunities.get("0").toString());
        System.out.println(Account.theAccounts.get("0").toString());

    }
}
