/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.models;

/**
 *
 * @author danie
 */
public abstract class SortAlgorithm {
    public final void sortAlgo(String[] sorting){
        sort(sorting);
    } 
    
    protected void sort(String[] sorting){
       String tempStr;
       for (int t = 0; t < sorting.length - 1; t++) {
            for (int i= 0; i < sorting.length - t - 1; i++) {
                if(compare(sorting[i+1].toLowerCase(), sorting[i].toLowerCase())) {
                    tempStr = sorting[i];
                    sorting[i] = sorting[i + 1];
                    sorting[i + 1] = tempStr;
                }
            }
        }
    }

    protected abstract boolean compare(String val1, String val2);
}
    
