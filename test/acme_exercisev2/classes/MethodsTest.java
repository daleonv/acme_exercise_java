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
public class MethodsTest {

    public MethodsTest() {
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
     * Test of getName method, of class Methods.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Methods instance = Methods.getInstance("ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00");
        String expResult = "ASTRID";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!expResult.equals(result)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getSalary method, of class Methods.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Methods instance = Methods.getInstance("ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00");
        int expResult = 85;         
        instance.setSalary();
        int result = instance.getSalary();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult) {
            fail("The test case is a prototype.");
        }
    }
}
