/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acme_exercisev2.classes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TextFileTest {

    public TextFileTest() {
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
     * Test of getPlain_text method, of class TextFile.
     */
    @Test
    public void testGetPlain_text() {
        System.out.println("validatePlainText");
        TextFile instance = TextFile.getInstance("input.txt");
        String expResult = "ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00";
        String result = instance.getPlain_text();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!expResult.equals(result)) {
            fail("The test case is a prototype.");
        }
    }

}
