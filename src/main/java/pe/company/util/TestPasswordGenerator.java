/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestPasswordGenerator 
{
    //método ejecutable
    public static void main(String[] args) 
    {
        PasswordEncoder bCrypt=new BCryptPasswordEncoder();
        
        System.out.println("admin: "+bCrypt.encode("admin"));
        System.out.println("c123: "+bCrypt.encode("c123"));
        System.out.println("j123: "+bCrypt.encode("j123"));
        System.out.println("a123: "+bCrypt.encode("a123"));
    }       
}
