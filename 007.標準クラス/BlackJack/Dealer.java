/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;
import java.util.ArrayList;
import java.util.Random;
//import java.io.PrintWriter;

/**
 *
 * @author guest1Day
 */
public class Dealer extends Human {
    ArrayList cards = this.myCards;//new ArrayList();
    
    public Dealer(){
        for(int j=0;j<4;j++){
            for (int i=1;i<14;i++){
                cards.add(i);
            }
        }
    }
    
    public ArrayList<Integer> deal(){
        
        ArrayList two = new ArrayList();
        for(int i=0;i<2;){
            Random rand = new Random();
            int num = rand.nextInt(13);
            
            if (cards.indexOf(num) != -1){
                two.add(num);
                cards.remove(num);
                //pw.print(two.get(1)+"と"+two.get(2)+"を配りました。");
                i++;
            } else if(cards.size() < 2){
                //.size()==0 と .isEmpty() は同じ
                System.out.print("カードが足りません");
                break;
            }
        }
        return two;
    }
    
    public ArrayList<Integer> hit(){
        ArrayList one = new ArrayList();
        Random rand = new Random();
        int num = rand.nextInt(13);
        if (cards.indexOf(num) != -1){
            one.add(num);
            cards.remove(num);
            //pw.print(one.get(1)+"を配りました。");
        }else if(cards.isEmpty()){
            System.out.print("カードが足りません");
        }
        return one;
    }
    
    public void setCard(ArrayList<Integer> AL){
        for (int i=0 ; i<AL.size() ; i++){
            this.myCards.add(AL.get(i));
        }
    }
    
    public boolean checkSum(ArrayList<Integer> AL){
        int Sum = open(AL);
        return Sum<21;
    }    
    public int open(ArrayList<Integer> AL){
        int Sum = 0;
        for (int i=0;i<AL.size();i++){
            Sum += AL.get(i);
        }
        return Sum;
    }
}