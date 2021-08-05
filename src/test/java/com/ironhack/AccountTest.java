package com.ironhack;

import com.ironhack.enums.Truck;
import com.ironhack.exceptions.*;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account acc;

    @BeforeEach
    void setUp() throws NameContainsNumbersException, EmptyStringException, EmailNotValidException,
            ExceedsMaxLength, PhoneNumberContainsLettersException {
        acc = new Account(new Contact("TestOne", "123546", "test1@test.gmail.com",
                "TestCompany1"), new Opportunity(Truck.BOX, 200, new Contact("TestOne",
                "123546", "test1@test.gmail.com", "TestCompany1")));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setEmployeeCount_shouldWork() throws ExceedsMaxLength {
        acc.setEmployeeCount(2);
        assertEquals(2, acc.getEmployeeCount());
    }

    @Test
    void setEmployeeCount_throwsException_IllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> { acc.setEmployeeCount(0);});
    }

    @Test
    void setCity_shouldWork() throws EmptyStringException, NameContainsNumbersException, ExceedsMaxLength {
        acc.setCity("Dubai");
        assertEquals("Dubai", acc.getCity());
    }

    @Test
    void setCity_throwsException_EmptyString() {
        Assertions.assertThrows(EmptyStringException.class, () -> { acc.setCity("");});
    }


    @Test
    void setCity_throwsException_ContainsNumbers() {
        Assertions.assertThrows(NameContainsNumbersException.class, () -> { acc.setCity("Madr1d");});
    }


    @Test
    void setCity_throwsException_ExceedsMaxLength() {
        Assertions.assertThrows(ExceedsMaxLength.class, () -> { acc.setCity("Longestnameeverseenonacity");});
    }

    @Test
    void setCountry_shouldWork() throws EmptyStringException, InvalidCountryException, ExceedsMaxLength {
       acc.setCountry("SPAIN");
      assertEquals("SPAIN", acc.getCountry());
    }


    @Test
    void setCountry_throwsException_EmptyString() {
     Assertions.assertThrows(EmptyStringException.class, () -> { acc.setCountry("");});
    }

    @Test
    void setCountry_throwsException_ExceedsMaxLength() {
      Assertions.assertThrows(ExceedsMaxLength.class, () -> { acc.setCountry("Longest country name really really long");});
    }

    @Test
    void setCountry_throwsException_InvalidCountry() {
      Assertions.assertThrows(InvalidCountryException.class, () -> { acc.setCountry("Japun");});
    }


}