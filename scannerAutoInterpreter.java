/* 
This program can find what kind of input is used
for a scanner input out of double int and 
single word string, multi word string

Author: TA Jonathan Lee
Professor: Gita Faroughi
Class: Sierra College CSCI12
Date: March 2 2021

*/
import java.util.Scanner;
public class scannerAutoInterpreter
{
   public static void main(String args[])
   {
      interpreter(); //calls main main run
   }
   /* Main run */
   public static void interpreter()
   {
      int Int = 0; //variables for equation
      int St = 0; //variable for string
      int Do = 0; 
      int Mwst = 1;
      Scanner console = new Scanner (System.in);
      System.out.print("Enter a variable value: ");
      if (console.hasNextInt() == true)
      {
         System.out.println("This can be a Int---> "+ console.hasNextInt());
         Int++;
      }
      if (console.hasNext() == true)
      {
         System.out.println("This can be a string---> "+ console.hasNext());
         St++;
      }
      if (console.hasNextLine() == true)
      {
         System.out.println("This can be a multiple word string---> "+console.hasNextLine()); 
         Mwst++;
      }
      if(console.hasNextDouble() == true)
      {
         System.out.println("This can be a double---> "+console.hasNextDouble());
         Do++;
      }
      String autointerpreter = console.nextLine();
      System.out.println();
      System.out.println(autointerpreter+ " is now going to run through three more testing methods");
      System.out.println();
      numbtest(autointerpreter, Int, Do, St, Mwst); // calls number test method
      wholenumtest(autointerpreter, Int, Do, St, Mwst); //calls whole number test
      Mwst = spacechartest(autointerpreter, Int, Do, St, Mwst); // calls and returns space char test
      System.out.println();
      //System.out.println(Int);
      //System.out.println(Do);
      //System.out.println(St);
      //System.out.println(Mwst); counter testing outputs
      if (Int==1 && Do==1 && St==1 && Mwst==1)
      {
         System.out.println("This is a whole number based off tests ran Scanner should be set to nextInt()");
         int scanner_variable_auto_set = Integer.parseInt(autointerpreter); 
      } 
      if (Int==0 && Do==1 && St==1 && Mwst==1)
      {
         System.out.println("This is a double based off tests ran Scanner should be set to nextDouble()");
         double scanner_variable_auto_set = Double.parseDouble(autointerpreter); 
      } 
      if (Int==0 && Do==0 && St==1 && Mwst==1)
      {
         System.out.println("This is a single word based off tests ran Scanner should be set to next()");
         String scanner_variable_auto_set = autointerpreter;
      }
      if (Int==0 && Do==0 && St == 1 && Mwst == 3)
      {
         System.out.println("This is a line string based off tests ran Scanner should be set to nextLine()\nand adjust enter key");
         String scanner_variable_auto_set = autointerpreter;
      }
      return;
   }
      
      
    /* does this have a decimal point */
   public static int numbtest(String s, int Int, int Do, int St, int Mwst)
   {
      try 
      {
         // checking valid integer using parseInt() method 
         int sum = Integer.parseInt(s); 
         System.out.println(s + " is a valid whole number this is only a int if needed");
         Int++;
         
      }  
      catch (NumberFormatException e)  
      { 
         System.out.println(s + " is not a valid whole number");
         Int--;
      }  
      return Int; 
   }
   
    /* checks for valid double */  
   public static int wholenumtest(String s, int Int, int Do, int St, int Mwst)
   {
      try 
      { 
         double floatcheck = Double.parseDouble(s); 
         System.out.println(floatcheck + " is a valid double");
         Do++;
      } 
      catch (Exception e) 
      { 
         System.out.println(s + " is not a valid double");
         Do--;
      }
      return Do;
   }
    
   
   /* This method checks to see if spaces are inside of string  */   
   public static int spacechartest(String s, int Int, int Do, int St, int Mwst)
   {
      if (s.indexOf(" ") == -1)
      {
         System.out.println(s + " has no spaces");
         Mwst--;
      }
      if (s.indexOf(" ") >= 0)
      {
         System.out.println(s + " has spaces inside");
         Mwst++;
      }
      return Mwst;
   }
}
