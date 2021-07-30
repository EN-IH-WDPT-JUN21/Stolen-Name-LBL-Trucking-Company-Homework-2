package com.ironhack;

import com.ironhack.enums.Industry;
import com.ironhack.enums.Status;
import com.ironhack.enums.Truck;
import com.ironhack.exceptions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.*;

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
            Assertions.assertEquals("NATHAN", MainMenu.theLeads.get(theNewLead.getId()).getName());
            Assertions.assertEquals("SANTANDER", MainMenu.theLeads.get(theNewLead.getId()).getCompanyName());
            Assertions.assertEquals("0028263", MainMenu.theLeads.get(theNewLead.getId()).getPhoneNumber());
            Assertions.assertEquals("122@GMAIL.COM", MainMenu.theLeads.get(theNewLead.getId()).getEmail());
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
    void testConvertLeadPositive() throws NameContainsNumbersException, EmptyStringException, EmailNotValidException, ExceedsMaxLength, PhoneNumberContainsLettersException {
        Assertions.assertEquals(0, MainMenu.theOpportunities.size());
        Assertions.assertEquals(0, MainMenu.theContacts.size());
        String data = "y \n box \n 20 \n \n \n"; // Used to simulate user input
        InputStream stdin = System.in; // Used to store default System.in
        Lead lead = MainMenu.theLeads.get(lead1.getId());
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes())); // Sets System.In to test1
            //int oppHashMapSize = MainMenu.theOpportunities.size();
            //int conHashMapSize = MainMenu.theContacts.size();
            MainMenu test = new MainMenu(); // Creates a sales associate to test method
            Opportunity newOpp = test.convertLead(String.valueOf(lead.getId()));
            //Assertions check Object created correctly and added to hashmap
            //Assertions.assertEquals(oppHashMapSize + 1, MainMenu.theOpportunities.size()); // Checks it's added to HashMap
            Assertions.assertEquals(Truck.BOX, MainMenu.theOpportunities.get(newOpp.getId()).getProduct());
            Assertions.assertEquals(20, MainMenu.theOpportunities.get(newOpp.getId()).getQuantity());
            //Assertions.assertEquals(conHashMapSize + 1, MainMenu.theContacts.size()); // Checks that new lead is added to array
            Assertions.assertEquals("TESTONE", newOpp.getDecisionMaker().getName());
            Assertions.assertEquals("TESTCOMPANY1", newOpp.getDecisionMaker().getCompanyName());
            Assertions.assertEquals("123546", newOpp.getDecisionMaker().getPhoneNumber());
            Assertions.assertEquals("TEST1@TEST.GMAIL.COM", newOpp.getDecisionMaker().getEmail());
        } finally {
            System.setIn(stdin); /// Resets System.in to default state
        }
    }

    @Test
    void TestCreateAccountPositive() throws NameContainsNumbersException, EmptyStringException, EmailNotValidException, PhoneNumberContainsLettersException, ExceedsMaxLength {
        String data = "Produce \n 200 \n Stourbridge \n United Kingdom \n"; // Used to simulate user input
        InputStream stdin = System.in; // Used to store default System.in

        Contact testContact = new Contact("TestContact", "1234567", "email@email.com",
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
            Assertions.assertEquals("STOURBRIDGE", MainMenu.theAccounts.get(testAccount.getId()).getCity());
            Assertions.assertEquals("UNITED KINGDOM", MainMenu.theAccounts.get(testAccount.getId()).getCountry());
        }finally {
            System.setIn(stdin); /// Resets System.in to default state
        }
    }


    @Test
    void TestQuitWorksInOS() {
        String data = "\n quit"; // Used to simulate user input
        InputStream stdin = System.in; // Used to store default System.in
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes())); // Sets System.In to test1

            MainMenu test = new MainMenu(); // Creates a sales associate to test method

            Assertions.assertThrows(RuntimeException.class, test::OS);
        }finally {
            System.setIn(stdin); /// Resets System.in to default state
        }
    }

    /* May come back to this to test console output if we have time
    @Test
    void testConvertLeadThrowsNoSuchValueException() throws NoSuchValueException, AWTException {
        String data = "convert lead 50\r"; // Used to simulate user input
        String expected = "There is no Lead that matches that id."; //Used to check system output
        InputStream stdin = System.in; // Used to store default System.in
        PrintStream stdout = System.out; //Used to store default System.out
        PrintStream originalErr = System.err;

        try {
            System.setIn(new ByteArrayInputStream(data.getBytes())); // Sets System.In to test1
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream((baos));

            System.setOut(printStream);


            MainMenu test = new MainMenu(); // Creates a sales associate to test method
            //test::OS;
            String lines = baos.toString();
            //String lines = baos.toString();
                    //.split(System.lineSeparator());
            String toCheck = lines;
            Assertions.assertEquals(expected, toCheck);
        }finally {
            System.setIn(stdin); /// Resets System.in to default state
            System.setOut(stdout); /// Resets System.out to default state
        }
    }
*/


    /*@Test
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
    }*/

    @Test
    void lookUpLeadId_FindLead() {
        Assertions.assertEquals("TestOne", MainMenu.theLeads.get(lead1.getId()).getName());
    }


    @Test
    void closeLost() throws NameContainsNumbersException, EmptyStringException, EmailNotValidException, PhoneNumberContainsLettersException, ExceedsMaxLength {

        String data = "y";
        InputStream stdin = System.in;

        Contact testContact = new Contact("TestContact", "1234567", "email@email.com",
                "TestContactCompany");
        Opportunity testOpp = new Opportunity(Truck.HYBRID, 30, testContact);
        MainMenu.theOpportunities.put(testOpp.getId(), testOpp);

        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            MainMenu test = new MainMenu();
            test.closeLost(testOpp.getId());
            Assertions.assertEquals(Status.CLOSED_LOST, MainMenu.theOpportunities.get(testOpp.getId()).getStatus());

        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    void closeWon() throws ExceedsMaxLength, NameContainsNumbersException, EmptyStringException, EmailNotValidException, PhoneNumberContainsLettersException {
        String data = "y";
        InputStream stdin = System.in;
        MainMenu test = new MainMenu();
        Contact testContact = new Contact("TestContact", "1234567", "email@email.com",
                "TestContactCompany");
        Opportunity testOpp = new Opportunity(Truck.HYBRID, 30, testContact);
        MainMenu.theOpportunities.put(testOpp.getId(), testOpp);

        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            test.closeWon(testOpp.getId());
            Assertions.assertEquals(Status.CLOSED_WON, MainMenu.theOpportunities.get(testOpp.getId()).getStatus());

        } finally {
            System.setIn(stdin);
        }
    }
}