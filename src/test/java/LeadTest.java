import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class LeadTest {

    @BeforeEach
    void setUp() {
        MainMenu menu = new MainMenu();
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
}


