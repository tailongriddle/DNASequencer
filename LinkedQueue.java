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
 * Creates and mutates LinkedQueues
 * 
 * @author tai
 *
 */
public class LinkedQueue<T> extends Object implements QueueADT<T> {
  protected Node<T> back;
  protected Node<T> front;
  private int n;

  /**
   * Adds input to queue to the back
   * 
   * @param data
   */
  @Override
  public void enqueue(T data) {

    Node<T> node = back; // stores old back data
    back = new Node<>(data, null); // sets back to new data
    if (front == null) {
      front = back; // sets front to new back data if null
    } else {
      node.setNext(back); // sets the node after node to new back
    }



    n++; // add one to size
  }

  /**
   * Removes and returns object at front
   * 
   */
  public T dequeue() {
    if (front == null) {
      throw new NoSuchElementException("Queue is empty!");
    }

    Node<T> toReturn = front;
    front = front.getNext();


    n--;
    return toReturn.getData();
  }

  /**
   * Returns item at the back
   * 
   */
  public T peek() {
    return back.getData();
  }

  /**
   * Returns true if queue is empty, false if not
   */
  public boolean isEmpty() {
    return (front == null);
  }

  /**
   * Returns size of queue
   */
  public int size() {
    return n;
  }

  /**
   * Returns String representation of queue
   */
  @Override
  public String toString() {
    Node<T> node = front;
    StringBuffer buff = new StringBuffer();


    for (int i = 0; i < n; i++) {
      buff.append(node.getData()).append(" ");
      node = node.getNext();

    }


    return buff.toString();
  }



}
