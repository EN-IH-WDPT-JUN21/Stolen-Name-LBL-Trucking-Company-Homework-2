import java.util.HashMap;
import java.util.Map;

public class Main {

    public static SalesAssociate nathan = new SalesAssociate("Nathan");

    public static void main(String[] args) {

        //nathan.newLead();

        Lead lead1 = new Lead("Nathan","07282920", "BLAH BLAH", "Starling" );
        nathan.convertLead(lead1);

        System.out.println(Lead.theLeads.toString());
        System.out.println(Opportunity.theOpportunities.toString());
        System.out.println(Account.theAccounts.toString());

        Contact contact1 = new Contact(lead1);

        Opportunity opp1 = new Opportunity(lead1, Truck.HYBRID, 5, contact1);
        Opportunity opp2 = new Opportunity(lead1, Truck.HYBRID, 5, contact1);
        Opportunity opp3 = new Opportunity(lead1, Truck.HYBRID, 5, contact1);
        Opportunity opp4 = new Opportunity(lead1, Truck.HYBRID, 5, contact1);
        Opportunity opp5 = new Opportunity(lead1, Truck.HYBRID, 5, contact1);

        Lead lead2 = new Lead("Nathan","07282920", "BLAH BLAH", "Starling" );
        Contact contact2 = new Contact(lead1);

        Opportunity opp10 = new Opportunity();

        System.out.println(opp10.getId());


        System.out.println(opp5.getId());
        System.out.println(lead2.getId());
        System.out.println(contact2.getId());
    }
}
