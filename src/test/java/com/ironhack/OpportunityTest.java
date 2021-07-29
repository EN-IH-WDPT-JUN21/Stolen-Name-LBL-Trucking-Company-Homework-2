package com.ironhack;

import com.ironhack.enums.Truck;
import com.ironhack.exceptions.*;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpportunityTest {

    Opportunity opp;

    @BeforeEach
    void setUp() throws ExceedsMaxLength, NameContainsNumbersException, EmptyStringException, EmailNotValidException,
            PhoneNumberContainsLettersException {
         opp = new Opportunity(Truck.BOX, 200, new Contact("TestOne", "123546",
                "test1@test.gmail.com", "TestCompany1"));
    }

    @AfterEach
    void tearDown() {

    }


    @Test
    void setQuantity_shouldWork() throws ExceedsMaxLength {
        opp.setQuantity(23);
        assertEquals(23, opp.getQuantity());
    }

    @Test
    void setQuantity_throwsException_IllegalArgument() {
        Assert.assertThrows(IllegalArgumentException.class, () -> { opp.setQuantity(-3);});
    }


}