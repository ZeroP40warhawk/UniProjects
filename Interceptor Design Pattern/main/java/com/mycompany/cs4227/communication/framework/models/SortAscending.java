package com.mycompany.cs4227.communication.framework.models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class SortAscending extends SortAlgorithm {
    
    @Override
    protected boolean compare(String val1, String val2) {
        return val1.compareTo(val2)<0;
    }
}