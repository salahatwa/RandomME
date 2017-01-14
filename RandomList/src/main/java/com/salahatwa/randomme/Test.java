/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.salahatwa.randomme;

import java.util.List;

/**
 *
 * @author Salah Atwa
 */
public class Test {
    
       public static void main(String[] args) {
       
        
        ReadXLS r=ReadXLS.getInstance();
        List<ReadedBean> oldList= r.readXLSFromFile("src/Main/java/testReadStudents.xlsx");
        List<ReadedBean> newList=RandomOperation.getRandomNumberFromList(3, oldList);
        for (ReadedBean readedBean : newList) {
            System.err.println(readedBean.getCell());
        }
        
    }
    
}
