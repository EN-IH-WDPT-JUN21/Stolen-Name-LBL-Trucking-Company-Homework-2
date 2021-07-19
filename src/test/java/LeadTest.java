import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class LeadTest {

    @BeforeEach
    void setUp() {
        Lead lead1 = new Lead("Test1", "testnum1", "test1@test.gmail.com", "TestCompany1");
        Lead lead2 = new Lead("Test2", "testnum1", "test1@test.gmail.com", "TestCompany1");
        Lead lead3 = new Lead("Test3", "testnum1", "test1@test.gmail.com", "TestCompany1");

        MainMenu.theLeads.put(lead1.getId(), lead1);
        MainMenu.theLeads.put(lead2.getId(), lead2);
        MainMenu.theLeads.put(lead3.getId(), lead3);
    }

    @AfterEach
    void tearDown() {
        MainMenu.theLeads.clear();
    }

    @Test
    void testNewLead() {
        String data = "y \n Nathan \n 0028263 \n 122@gmail.com \n Santander \n"; // Used to simulate user input
        InputStream stdin = System.in; // Used to store default System.in
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes())); // Sets System.In to test1
            MainMenu test = new MainMenu(); // Creates a sales associate to test method
            Assertions.assertEquals(3, MainMenu.theLeads.size()); // Checks theLeads array is empty
            test.newLead(); // creates new lead
            Assertions.assertEquals(4, MainMenu.theLeads.size()); // Checks that new lead is added to array
            Assertions.assertEquals("4", MainMenu.theLeads.get("4").getId()); // Checks correct Id
            Assertions.assertEquals("Nathan", MainMenu.theLeads.get("4").getName());
            Assertions.assertEquals("Santander", MainMenu.theLeads.get("4").getCompanyName());
            Assertions.assertEquals("0028263", MainMenu.theLeads.get("4").getPhoneNumber());
            Assertions.assertEquals("122@gmail.com", MainMenu.theLeads.get("4").getEmail());
        } finally {
            System.setIn(stdin); /// Resets System.in to default state
        }
    }

    @Test
    void testConvertLeadOutofBoundds(){
        MainMenu test = new MainMenu(); // Creates a sales associate to test method
        Assertions.assertThrows(NullPointerException.class, () -> test.convertLead("20"));
    }

    @Test
    void testConvertLead() {
        MainMenu test = new MainMenu(); // Creates a sales associate to test method
        String data = "y \n box \n 20 \n \n Other \n 20 \n Stour \n UK \n"; // Used to simulate user input
        InputStream stdin = System.in; // Used to store default System.in
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes())); // Sets System.In to test1
            Assertions.assertEquals(0, MainMenu.theOpportunities.size()); // Checks array is empty
            test.convertLead(MainMenu.theLeads.get("1").getId());
            Assertions.assertEquals(1, MainMenu.theOpportunities.size()); // Checks it's added to array
            Assertions.assertEquals(Truck.BOX, MainMenu.theOpportunities.get("0").getProduct());

        } finally {
            System.setIn(stdin); /// Resets System.in to default state
        }
    }
}



