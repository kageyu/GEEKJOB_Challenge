/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample.クラス;

/**
 *
 * @author guest1Day
 */
public class Challenge12 {
    public int i = 0;
    public String s = "";
    public void method1(int x,String y) {
        this.i = x;
        this.s = y;
    }
    public void method2(){
        System.out.print(i+"番目は"+s+"です。<br>");
    }
}
