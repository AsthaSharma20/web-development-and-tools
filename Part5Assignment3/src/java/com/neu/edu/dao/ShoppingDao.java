/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.dao;

import com.neu.edu.pojo.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asthasharma
 */
public class ShoppingDao {
    
    public ArrayList<Item> addItems(String[] items,ArrayList<Item> itemList){
        
        for(String aa:items){
            boolean isThere=false;
            if(itemList.size()>0)
            {
                for(Item it:itemList){
                    if(it.getName().equals(aa)){
                        isThere=true;
                        break;
                    }
                }
                if(!isThere){
                    Item item=new Item();
                    item.setName(aa);
                    itemList.add(item);
                }
            }
            else{
                Item item=new Item();
                item.setName(aa);
                itemList.add(item);

                
            }
            
        }
        return itemList;
        
    }
    
    public List<Item> removeItem(String[] items,List<Item> itemList){
        for(String item:items){
            for(Item m:itemList){
                if(item.equals(m.getName())){
                    itemList.remove(m);
                    break;
                }
            }
        }
        return itemList;
        
    }
    
}
