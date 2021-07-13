import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class SalesAssociateTest {


    @Test
    void testNewLead() {
        String data = "y \n Nathan \n 0028263 \n 122@gmail.com \n Santander \n"; // Used to simulate user input
        InputStream stdin = System.in; // Used to store default System.in
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes())); // Sets System.In to test1
            SalesAssociate test = new SalesAssociate("Test"); // Creates a sales associate to test method
            Assertions.assertEquals(0, Lead.theLeads.size()); // Checks theLeads array is empty
            test.newLead(); // creates new lead
            Assertions.assertEquals(1, Lead.theLeads.size()); // Checks that new lead is added to array
            Assertions.assertEquals("0", Lead.theLeads.get("0").getId()); // Checks correct Id
            Assertions.assertEquals("Nathan", Lead.theLeads.get("0").getName());
            Assertions.assertEquals("Santander", Lead.theLeads.get("0").getCompanyName());
            Assertions.assertEquals("0028263", Lead.theLeads.get("0").getPhoneNumber());
            Assertions.assertEquals("122@gmail.com", Lead.theLeads.get("0").getEmail());
        } finally {
            System.setIn(stdin); /// Resets System.in to default state
        }
    }

    @Test
    void testConvertLead() {
        Lead testLead = new Lead("Nathan", "123456", "hello@hello.com", "Santander");
        SalesAssociate test = new SalesAssociate("Test"); // Creates a sales associate to test method
        String data = "y \n box \n 20 \n"; // Used to simulate user input
        InputStream stdin = System.in; // Used to store default System.in
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes())); // Sets System.In to test1
            Assertions.assertEquals(0, Opportunity.theOpportunities.size()); // Checks array is empty
            test.convertLead(testLead);
            Assertions.assertEquals(1, Opportunity.theOpportunities.size()); // Checks it's added to array
            Assertions.assertEquals(Truck.BOX, Opportunity.theOpportunities.get("0").getTruck());

        } finally {
            System.setIn(stdin); /// Resets System.in to default state
        }
    }
}