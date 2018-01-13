/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.student.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prade
 */
public class StudentUtilTest {
    
    public StudentUtilTest() {
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

    @Test
    public void testForPostHighSchool() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        StudentUtil studentUtil = new StudentUtil() ;
        int grade = studentUtil.getGradeOnGivenDate("2023-06-25", "2023-06-30") ;
        assertEquals("Post-High-School is represented by 99", 99, grade);
    }
    
    @Test
    public void testFor12() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        StudentUtil studentUtil = new StudentUtil() ;
        int grade = studentUtil.getGradeOnGivenDate("2023-06-25", "2023-06-25") ;
        assertEquals("Grade 12", 12, grade);
    }
    @Test
    public void testForPreK() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        StudentUtil studentUtil = new StudentUtil() ;
        int grade = studentUtil.getGradeOnGivenDate("2023-06-25", "2010-06-25") ;
        assertEquals("PreK", -1, grade);
    }
    @Test
    public void testKinderGarten() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        StudentUtil studentUtil = new StudentUtil() ;
        int grade = studentUtil.getGradeOnGivenDate("2023-06-25", "2010-07-01") ;
        assertEquals("KinderGarten", 0, grade);
    }
    @Test
    public void testGradeLevel1() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        StudentUtil studentUtil = new StudentUtil() ;
        int grade = studentUtil.getGradeOnGivenDate("2023-06-25", null) ;
        assertEquals("Grade 7", 7, grade);
    }
    @Test
    public void testGradeLevel2() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        StudentUtil studentUtil = new StudentUtil() ;
        int grade = studentUtil.getGradeOnGivenDate("2023-06-25", "2018-07-01") ;
        assertEquals("Grade 8", 8, grade);
    }
    @Test
    public void testGradeLevel3() {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        StudentUtil studentUtil = new StudentUtil() ;
        int grade = studentUtil.getGradeOnGivenDate("2023-06-25", "2023-06-24") ;
        assertEquals("Grade 12", 12, grade);
    }
    
}
