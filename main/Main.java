/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import View.LoginForm;
import View.MainJFrame;


public class Main {
    public static void main(String[] args){
        new MainJFrame().setVisible(true);
        LoginForm login = new LoginForm(null,true);
        login.setTitle("Đăng nhập hệ thống");
        login.setVisible(true);
    }
    
}
