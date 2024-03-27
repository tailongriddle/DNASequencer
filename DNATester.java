
//////////////// FILE HEADER //////////////////////////
//
// Title: P08 DNA Transcription
// Course: CS 300 Spring 2022
//
// Author: Tai-Long Riddle
// Email: mlriddle@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: piazza
// Online Sources: Piazza :)
//
/////////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * Test methods to verify your implementation of the methods for P08.
 * 
 * @author tai
 */
public class DNATester {


  /**
   * Tests the transcribeDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {

    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String mRNA = "C C U C A G U C A A U U C G C U G G C C C U G U A U G A C "
        + "A G A A C C A U U A G A G G C U C G A U C U U U C A G A G A C";
    if (!testDNA.transcribeDNA().toString().trim().equals(mRNA)) {
      System.out.println(testDNA.transcribeDNA().toString().trim());
      System.out.println(mRNA);

      return false;
    }

    return true;
  }

  /**
   * Tests the translateDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranslateDNA() {
    DNA testDNA = new DNA("AAAAATAAA");

    if (!testDNA.translateDNA().toString().trim().equals("F L F")) {
      System.out.println(testDNA.translateDNA().toString());

      return false;
    }

    System.out.println(testDNA.translateDNA().toString());
    
    return true;
  }

  public static boolean testQueueSize() {
    try {
      LinkedQueue<String> test = new LinkedQueue<>();
      test.enqueue("cat");
      test.enqueue("dog");


      try {
        if (test.size() != 2) {
          return false;
        }
      } catch (NullPointerException e) {
        return false;
      }

      test.dequeue();

      if (test.size() != 1) {
        return false;
      }

      if (test.isEmpty()) {
        return false;
      }

      test.dequeue();

      if (test.size() != 0) {
        return false;
      }

      if (!test.isEmpty()) {
        return false;
      }

      try {
        test.size();
      } catch (NullPointerException e) {
        return false;
      }


      return true;
    } catch (NullPointerException e) {
      return false;
    }
  }

  /**
   * Tests enqueue() and dequeue() methods
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testEnqueueDequeue() {
    try {
      int ticker = 0;
      LinkedQueue<String> test = new LinkedQueue<>();

      test.enqueue("check");
      test.enqueue("wrong");
      try {
        if (!test.front.getData().equals("check")) {
          System.out.println(test.front.getData());
          return false;
        }

        test.dequeue();
        if (test.front.getData().equals("check")) {
          return false;
        }


        if (!test.toString().equals("wrong ")) {
          System.out.println(test.toString());
          return false;
        }

        test.enqueue("check");

        if (!test.toString().equals("wrong check ")) {
          System.out.println(test.toString());
          return false;
        }

        test.dequeue();

        test.dequeue();

        if (!test.toString().equals("")) {
          System.out.println(test.toString());
          return false;
        }

      } catch (NullPointerException e) {
        return false;
      }

      try {
        test.dequeue();
      } catch (NoSuchElementException e) {
        ticker++;
      }

      if (ticker != 1) {
        return false;
      }


      return true;
    } catch (NullPointerException e) {
      return false;
    }
  }

  /**
   * Tests the mRNATranslateDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testMRNATranslate() {
    String mRNA = "AAAAAT";
    DNA test = new DNA(mRNA);
    LinkedQueue<Character> test2 = test.transcribeDNA();
    String equals = "F L";


    if (!test.mRNATranslate(test2).toString().trim().equals(equals)) {
      System.out.println(test.mRNATranslate(test2).toString());
      return false;
    }

    return true;

  }

  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("transcribeDNA: " + testTranscribeDNA());
    System.out.println("mRNATranslate: " + testMRNATranslate());
    System.out.println("translateDNA: " + testTranslateDNA());
    System.out.println("EnqueueDequeue: " + testEnqueueDequeue());
    System.out.println("QueueSize: " + testQueueSize());


  }

}
