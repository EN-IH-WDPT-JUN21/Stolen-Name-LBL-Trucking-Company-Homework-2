package com.ironhack;

import com.ironhack.enums.Industry;
import com.ironhack.enums.Truck;
import com.ironhack.exceptions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class MainMenuTest {

    Integer counterStatus;
    Lead lead1;
    Lead lead2;
    Lead lead3;


    @BeforeEach
    void setUp() throws NameContainsNumbersException, EmptyStringException, EmailNotValidException, PhoneNumberContainsLettersException, ExceedsMaxLength {
        counterStatus = ClientInformation.getUniqueID();
        ClientInformation.setUniqueID(0);
        lead1 = new Lead("TestOne", "123546", "test1@test.gmail.com", "TestCompany1");
        lead2 = new Lead("TestTwo", "654987", "test1@test.gmail.com", "TestCompany1");
        lead3 = new Lead("TestThree", "7536836", "test1@test.gmail.com", "TestCompany1");

        MainMenu.theLeads.put(lead1.getId(), lead1);
        MainMenu.theLeads.put(lead2.getId(), lead2);
        MainMenu.theLeads.put(lead3.getId(), lead3);
    }

    @AfterEach
    void tearDown() {
        MainMenu.theLeads.remove(lead1.getId(), lead1);
        MainMenu.theLeads.remove(lead2.getId(), lead2);
        MainMenu.theLeads.remove(lead3.getId(), lead3);
        ClientInformation.setUniqueID(counterStatus);
    }

    @Test
    void testNewLeadPositive() {
        String data = "y \n Nathan \n 0028263 \n 122@gmail.com \n Santander \n"; // Used to simulate user input
        InputStream stdin = System.in; // Used to store default System.in
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes())); // Sets System.In to test1
            int hashMapSize = MainMenu.theLeads.size();
            MainMenu test = new MainMenu(); // Creates a sales associate to test method

            Lead theNewLead = test.newLead(); // creates new lead
            //Assertions check Object created correctly and added to hashmap
            Assertions.assertEquals(hashMapSize + 1, MainMenu.theLeads.size()); // Checks that new lead is added to array
            Assertions.assertEquals("Nathan", MainMenu.theLeads.get(theNewLead.getId()).getName());
            Assertions.assertEquals("Santander", MainMenu.theLeads.get(theNewLead.getId()).getCompanyName());
            Assertions.assertEquals("0028263", MainMenu.theLeads.get(theNewLead.getId()).getPhoneNumber());
            Assertions.assertEquals("122@gmail.com", MainMenu.theLeads.get(theNewLead.getId()).getEmail());
        } finally {
            System.setIn(stdin); /// Resets System.in to default state
        }
    }

    @Test
    void testConvertLeadThrowsNullPointerException(){
        MainMenu test = new MainMenu(); // Creates a sales associate to test method

        Assertions.assertThrows(NullPointerException.class, () -> test.convertLead("239832487248"));
        Assertions.assertThrows(NullPointerException.class, () -> test.convertLead("Sausage"));
    }

    @Test
    void testConvertLeadPositive() {
        Assertions.assertEquals(0, MainMenu.theOpportunities.size());
        Assertions.assertEquals(0, MainMenu.theContacts.size());
        MainMenu test = new MainMenu(); // Creates a sales associate to test method

        String data = "y \n box \n 20 \n"; // Used to simulate user input
        InputStream stdin = System.in; // Used to store default System.in

        try {
            System.setIn(new ByteArrayInputStream(data.getBytes())); // Sets System.In to test1
            int oppHashMapSize = MainMenu.theOpportunities.size();
            int conHashMapSize = MainMenu.theContacts.size();

            Opportunity newOpp = test.convertLead(MainMenu.theLeads.get(String.valueOf(counterStatus + 1)).getId());
            //Assertions check Object created correctly and added to hashmap
            Assertions.assertEquals(oppHashMapSize + 1, MainMenu.theOpportunities.size()); // Checks it's added to HashMap
            Assertions.assertEquals(Truck.BOX, MainMenu.theOpportunities.get(newOpp.getId()).getProduct());
            Assertions.assertEquals(20, MainMenu.theOpportunities.get(newOpp.getId()).getQuantity());
            Assertions.assertEquals(conHashMapSize + 1, MainMenu.theContacts.size()); // Checks that new lead is added to array
            Assertions.assertEquals("Test1", newOpp.getDecisionMaker().getName());
            Assertions.assertEquals("TestCompany1", newOpp.getDecisionMaker().getCompanyName());
            Assertions.assertEquals("testnum1", newOpp.getDecisionMaker().getPhoneNumber());
            Assertions.assertEquals("test1@test.gmail.com", newOpp.getDecisionMaker().getEmail());
        } finally {
            System.setIn(stdin); /// Resets System.in to default state
        }
    }
    @Test
    void TestCreateAccountPositive() throws NameContainsNumbersException, EmptyStringException, EmailNotValidException, PhoneNumberContainsLettersException, ExceedsMaxLength {
        String data = "Produce \n 200 \n Stourbridge \n England \n"; // Used to simulate user input
        InputStream stdin = System.in; // Used to store default System.in

        Contact testContact = new Contact("TestContact", "TestContactNumber", "TestContactEmail",
                "TestContactCompany");
        Opportunity testOpp = new Opportunity(Truck.HYBRID, 30, testContact);

        try {
            System.setIn(new ByteArrayInputStream(data.getBytes())); // Sets System.In to test1
            int accHashMapSize = MainMenu.theAccounts.size();
            MainMenu test = new MainMenu(); // Creates a sales associate to test method

            Account testAccount = test.createAccount(testOpp);
            //Assertions check Object created correctly and added to hashmap
            Assertions.assertEquals(accHashMapSize + 1, MainMenu.theAccounts.size()); // Checks it's added to HashMap
            Assertions.assertEquals(Industry.PRODUCE, MainMenu.theAccounts.get(testAccount.getId()).getIndustry());
            Assertions.assertEquals(200, MainMenu.theAccounts.get(testAccount.getId()).getEmployeeCount());
            Assertions.assertEquals("Stourbridge", MainMenu.theAccounts.get(testAccount.getId()).getCity());
            Assertions.assertEquals("England", MainMenu.theAccounts.get(testAccount.getId()).getCountry());
        }finally {
            System.setIn(stdin); /// Resets System.in to default state
        }
    }


    @Test
    void TestQuitWorksInOS() {
        String data = "quit"; // Used to simulate user input
        InputStream stdin = System.in; // Used to store default System.in
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes())); // Sets System.In to test1

            MainMenu test = new MainMenu(); // Creates a sales associate to test method

            Assertions.assertThrows(RuntimeException.class, test::OS);
        }finally {
            System.setIn(stdin); /// Resets System.in to default state
        }
    }

    @Test
    void showLeads() {

    }

    @Test
    void showContacts() {
    }

    @Test
    void showOpportunities() {
    }

    @Test
    void showAccounts() {
    }

    @Test
    void lookUpLeadId() {
    }


}