/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.dialogs;

import javax.swing.JOptionPane;

/**
 *
 * @author Rory
 */
class ErrorOption implements IOptionPaneInterface{
    
    
    @Override
    public void show() {
        JOptionPane.showMessageDialog(null, "Error: Username already in use.");
    }
    
}
