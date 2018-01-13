/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.student.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author prade
 * Assumtion: After June 30 student is going to be in the next grade.
 */
public class StudentUtil 
{
    
    private static int actEndMonth = 6;
    private static int actEndDay=30;
   
    static public void main(String args[])
    {
        int grade ;
        if(args.length < 1) 
        {
            usage() ; 
            System.exit(0);
        }

        StudentUtil studentUtil = new StudentUtil() ;
        if(args.length >= 2)
             grade = studentUtil.getGradeOnGivenDate(args[0], args[1]) ;
        else 
             grade = studentUtil.getGradeOnGivenDate(args[0], null) ;
        System.out.println("Student Grade : " + grade) ;
        System.out.println("\nAssumption: After June 30 student is going to be in the next grade ") ;
    }
    private static void usage() 
    {
        System.out.println("Usage: StudentUtil YYYY-MM-DD(Graduation date) YYYY-MM-DD (Given date) - Given date is an optional field");
        
    }
    public StudentUtil ()
    {

    }
    //Assumtion: After June 30 student is going to in the next grade.
    public int getGradeOnGivenDate(String highSchoolGradDate, String givenDate)
    {
       int returnValue=0;
       LocalDate localDateHSGradDate ;
       LocalDate localDateGivenDate ;
       
        if(givenDate == null)
           givenDate = LocalDate.now().toString() ;
        
       localDateHSGradDate = LocalDate.parse(highSchoolGradDate) ;
       localDateGivenDate = LocalDate.parse(givenDate) ;
       
        if(localDateHSGradDate.isBefore(localDateGivenDate))
                returnValue = 99 ;
        else if(localDateHSGradDate.isEqual(localDateGivenDate))
                returnValue = 12 ;
        else
            returnValue = findGrade(localDateHSGradDate, localDateGivenDate) ;
       
       return returnValue ;
    }
    private int findGrade(LocalDate localDateHSGradDate, LocalDate localDateGivenDate)
    {
       int returnValue;
       int gradMonth ;
       int gradDay ;
       int givenMonth;
       int givenDay;
       
       gradMonth    = localDateHSGradDate.getMonthValue();
       gradDay      = localDateHSGradDate.getDayOfMonth();
       
       givenMonth    = localDateGivenDate.getMonthValue();
       givenDay      = localDateGivenDate.getDayOfMonth();
       
       long numberOfYears = ChronoUnit.YEARS.between(localDateHSGradDate, localDateGivenDate);
       
       returnValue = (int)numberOfYears +12 ;
           
       boolean  afterGradDay= isAfterGradDay(gradMonth, gradDay, givenMonth, givenDay) ;
       boolean  beforeCloseDay = isBeforeClose(givenMonth, givenDay) ;
       
       if((afterGradDay && beforeCloseDay))
               returnValue -=1 ;
      
       if(returnValue < 0)
           returnValue = -1 ;
       return returnValue ;
               
    }
 
  
    private boolean isBeforeClose(int givenMonth, int givenDay)
    {
        boolean returnFlag=false;

        if(givenMonth > StudentUtil.actEndMonth)
          returnFlag=false;
        else if (givenMonth == StudentUtil.actEndMonth)
        {
            if(givenDay <= StudentUtil.actEndDay)
                returnFlag=true;
        }
        //System.out.println("isBeforeClose return value :" + returnFlag) ;
        return returnFlag ;
    }
 
    private boolean isAfterGradDay(int gradMonth, int gradDay, int givenMonth, int givenDay)
    {
        boolean returnFlag=true;


        if(gradMonth < givenMonth)
          returnFlag=false;
        else if (gradMonth == givenMonth)
        {
            if(givenDay <= gradDay)
                returnFlag=false;
        }
        //System.out.println("isAfterGradDay return value :" + returnFlag) ;
        return returnFlag ;
    }
      
}
