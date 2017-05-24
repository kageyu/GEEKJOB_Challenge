/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;
import java.util.ArrayList;

/**
 *
 * @author guest1Day
 */

public abstract class Human {
    abstract public int open(ArrayList<Integer> AL);
    abstract public void setCard(ArrayList<Integer> AL);
    abstract public boolean checkSum(ArrayList<Integer> AL);
    ArrayList<Integer> myCards = new ArrayList<>();
}
