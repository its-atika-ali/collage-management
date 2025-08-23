/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.apnweb.utilities;

/**
 *
 * @author ADMIN
 */
public class Utils {
      public static <T> T requireNonNull(T object, String message){
        if( object == null || object.equals("") || object.equals(" ") || object.equals("null")){
            throw new RuntimeException(message);
            
        }
        return object;
    }
    
}
