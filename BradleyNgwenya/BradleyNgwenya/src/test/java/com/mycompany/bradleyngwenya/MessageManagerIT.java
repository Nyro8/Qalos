/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.bradleyngwenya;

import java.util.List;
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
public class MessageManagerIT {
    
    public MessageManagerIT() {
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
     * Test of addMessage method, of class MessageManager.
     */
    @Test
    public void testAddMessage() {
        System.out.println("addMessage");
        String message = "";
        String catergory = "";
        String id = "";
        String hash = "";
        MessageManager instance = new MessageManager();
        instance.addMessage(message, catergory, id, hash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findLongestMessage method, of class MessageManager.
     */
    @Test
    public void testFindLongestMessage() {
        System.out.println("findLongestMessage");
        MessageManager instance = new MessageManager();
        String expResult = "";
        String result = instance.findLongestMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByMessageID method, of class MessageManager.
     */
    @Test
    public void testSearchByMessageID() {
        System.out.println("searchByMessageID");
        String id = "";
        MessageManager instance = new MessageManager();
        String expResult = "";
        String result = instance.searchByMessageID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchMessageByRecipient method, of class MessageManager.
     */
    @Test
    public void testSearchMessageByRecipient() {
        System.out.println("searchMessageByRecipient");
        String recipient = "";
        MessageManager instance = new MessageManager();
        List<String> expResult = null;
        List<String> result = instance.searchMessageByRecipient(recipient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletedMessageByHash method, of class MessageManager.
     */
    @Test
    public void testDeletedMessageByHash() {
        System.out.println("deletedMessageByHash");
        String hash = "";
        MessageManager instance = new MessageManager();
        boolean expResult = false;
        boolean result = instance.deletedMessageByHash(hash);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayReport method, of class MessageManager.
     */
    @Test
    public void testDisplayReport() {
        System.out.println("displayReport");
        MessageManager instance = new MessageManager();
        instance.displayReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
