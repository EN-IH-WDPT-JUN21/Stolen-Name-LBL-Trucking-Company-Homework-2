
public class Main {

    public static SalesAssociate nathan = new SalesAssociate("Nathan");

    public static void main(String[] args) {

        nathan.newLead();

        Lead lead1 = new Lead("Nathan","07282920", "BLAH BLAH", "Starling" );
        Lead lead2 = new Lead("Nigel","072829201", "myemail@email.com", "Starling" );
        Lead lead3 = new Lead("Norbert","0728292043", "myemail2@email.com", "Starling" );

        Lead.theLeads.put(lead1.getId(), lead1);
        Lead.theLeads.put(lead2.getId(), lead2);
        Lead.theLeads.put(lead3.getId(), lead3);

        Opportunity opp1 = new Opportunity();

        //nathan.convertLead(lead2);

        System.out.println(nathan.lookUpLeadId("2").getEmail());


    }
}
