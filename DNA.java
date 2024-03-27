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

/**
 * Class that creates, transcribes, and translates DNA
 * 
 * @author tai
 *
 */
public class DNA extends Object {
  protected static String[][] mRNAtoProteinMap =
      {{"UUU", "F"}, {"UUC", "F"}, {"UUA", "L"}, {"UUG", "L"}, {"UCU", "S"}, {"UCC", "S"},
          {"UCA", "S"}, {"UCG", "S"}, {"UAU", "Y"}, {"UAC", "Y"}, {"UAA", "STOP"}, {"UAG", "STOP"},
          {"UGU", "C"}, {"UGC", "C"}, {"UGA", "STOP"}, {"UGG", "W"}, {"CUU", "L"}, {"CUC", "L"},
          {"CUA", "L"}, {"CUG", "L"}, {"CCU", "P"}, {"CCC", "P"}, {"CCA", "P"}, {"CCG", "P"},
          {"CAU", "H"}, {"CAC", "H"}, {"CAA", "Q"}, {"CAG", "Q"}, {"CGU", "R"}, {"CGC", "R"},
          {"CGA", "R"}, {"CGG", "R"}, {"AUU", "I"}, {"AUC", "I"}, {"AUA", "I"}, {"AUG", "M"},
          {"ACU", "T"}, {"ACC", "T"}, {"ACA", "T"}, {"ACG", "T"}, {"AAU", "N"}, {"AAC", "N"},
          {"AAA", "K"}, {"AAG", "K"}, {"AGU", "S"}, {"AGC", "S"}, {"AGA", "R"}, {"AGG", "R"},
          {"GUU", "V"}, {"GUC", "V"}, {"GUA", "V"}, {"GUG", "V"}, {"GCU", "A"}, {"GCC", "A"},
          {"GCA", "A"}, {"GCG", "A"}, {"GAU", "D"}, {"GAC", "D"}, {"GAA", "E"}, {"GAG", "E"},
          {"GGU", "G"}, {"GGC", "G"}, {"GGA", "G"}, {"GGG", "G"}};
  protected LinkedQueue<Character> DNA;

  /**
   * Constructor for a DNA sequence
   * 
   * @param sequence
   */
  public DNA(String sequence) {
    DNA = new LinkedQueue<Character>();
    Node<Character> toAdd = new Node<Character>(sequence.charAt(0));
    for (int i = 0; i < sequence.length() - 1; i++) {
      toAdd = new Node<Character>(sequence.charAt(i));
      DNA.enqueue(toAdd.getData());
    }
    int lengthMinus = sequence.length() - 1;

    DNA.enqueue(sequence.charAt(lengthMinus));

  }

  /**
   * Creates and returns new queue of mRNA characters from DNA
   * 
   * @return transcribed DNA
   */
  public LinkedQueue<Character> transcribeDNA() {

    LinkedQueue<Character> toReturn = DNA;


    for (int i = 0; i < DNA.size(); i++) {
      Character check = toReturn.dequeue();

      if (check.equals('A')) {
        toReturn.enqueue('U');
      } else if (check.equals('T')) {
        toReturn.enqueue('A');
      } else if (check.equals('C')) {
        toReturn.enqueue('G');
      } else if (check.equals('G')) {
        toReturn.enqueue('C');
      }

    }


    return toReturn;
  }

  /**
   * Translates mRNA with amino acid sequence
   * 
   * @param mRNAF
   * @return mRNA array
   */
  public LinkedQueue<String> mRNATranslate(LinkedQueue<Character> mRNA) {
    LinkedQueue<String> toReturn = new LinkedQueue<>();
    String check = "";
    LinkedQueue<Character> copy = mRNA;

    while ((copy.size() % 3) == 0 && (copy.size() != 0)) {
      check += copy.dequeue();
      check += copy.dequeue();
      check += copy.dequeue();


      for (int i = 0; i < mRNAtoProteinMap.length; i++) {
        if (check.equals(mRNAtoProteinMap[i][0])) {
          if (mRNAtoProteinMap[i][1].equals("STOP")) {
            return toReturn;
          }
          toReturn.enqueue(mRNAtoProteinMap[i][1]);
          break;
        }


      }

      check = "";

    }
    return toReturn;
  }

  /**
   * Combines mRNATranslate and transcribeDNA into a concise method
   * 
   * @return LinkedQueue of amino acids
   */
  public LinkedQueue<String> translateDNA() {
    LinkedQueue<Character> mRNA = transcribeDNA();
    return mRNATranslate(mRNA);
  }



}


