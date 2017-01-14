/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.salahatwa.randomme;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Salah Atwa
 */
public class RandomOperation {
    
    public static List<ReadedBean> getRandomNumberFromList(int numberOFRandomNumber,List<ReadedBean> beans)
    {
        List<ReadedBean> data =new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
         Random random = new Random(50);
        
        for (int i = 0; i < numberOFRandomNumber; i++) 
        {
           int randomIndex=random.nextInt(beans.size());
           if(!numbers.contains(randomIndex))
           {
               numbers.add(randomIndex);
               data.add(beans.get(randomIndex));
           }
        }
        
        return data;
    }
}
