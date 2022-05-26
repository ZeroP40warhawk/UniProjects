/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContextObject;

import contextobjects.ContextObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alan
 */
public class ContextObjectTest {
    
    public ContextObjectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createLog method, of class ContextObject.
     */
    @Test
    public void testCreateLog() {
        System.out.println("createLog");
        ContextObject instance = new ContextObject("TestChannel","TestMessage","TestUser","UnusedParam");
        instance.createLog();
        //Expected output for createlog is a formatted string written to file
    }

    /**
     * Test of setTextString method, of class ContextObject.
     */
    @Test
    public void testSetTextString() {
        System.out.println("setTextString");
        String newText = "Test Message";
        ContextObject instance;
        instance = new ContextObject("Test Channel", "Test Message", "TestUser", "event");
        instance.setTextString(newText);
        String result = instance.getTextString();
        assertEquals(newText, result);
        //Tests for string being set within context object
    }

    /**
     * Test of getTextString method, of class ContextObject.
     */
    @Test
    public void testGetTextString() {
        System.out.println("getTextString");
        ContextObject instance = new ContextObject("TestChannel","TestMessage","TestUser","UnusedParam");
        String expResult = "TestMessage";
        String result = instance.getTextString();
        assertEquals(expResult, result);
        //test for string being returned from context object
    }
    
}
