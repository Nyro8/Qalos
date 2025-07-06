/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.bradleyngwenya;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class BradleyNgwenyaTest {
    
    public BradleyNgwenyaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class BradleyNgwenya.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BradleyNgwenya.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateUsername method, of class BradleyNgwenya.
     */
    @Test
    public void testValidateUsername() {
        System.out.println("validateUsername");
        String username = "";
        String expResult = "";
        String result = BradleyNgwenya.validateUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePassword method, of class BradleyNgwenya.
     */
    @Test
    public void testValidatePassword() {
        System.out.println("validatePassword");
        String password = "";
        String expResult = "";
        String result = BradleyNgwenya.validatePassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateCellNumber method, of class BradleyNgwenya.
     */
    @Test
    public void testValidateCellNumber() {
        System.out.println("validateCellNumber");
        String cellNumber = "";
        String expResult = "";
        String result = BradleyNgwenya.validateCellNumber(cellNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class BradleyNgwenya.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "";
        String password = "";
        String expResult = "";
        String result = BradleyNgwenya.login(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
