/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;
//import BlackJack.Human;
import java.util.ArrayList;
//import java.io.PrintWriter;

/**
 *
 * @author guest1Day
 */
public class User extends Human {
    //public ArrayList<Integer> 
    public void setCard(ArrayList<Integer> AL){
        for (int i=0 ; i<AL.size() ; i++){
//            if(AL.isEmpty()){
//                break;
//            }
            this.myCards.add(AL.get(i));
        }
    }
    
    public boolean checkSum(ArrayList<Integer> AL){
        int Sum = open(AL);
        return Sum<21;
//        int Sum = 0;
//        for (int i=0 ; i<AL.size();i++){
//            Sum += i;
//        }
//        if (Sum<21){
//            return true;
//        }else{
//            return false;
//        }
    }    
    public int open(ArrayList<Integer> AL){
        int Sum = 0;
        for (int i=0;i<AL.size();i++){
            Sum += AL.get(i);
        }
        return Sum;
    }
}
