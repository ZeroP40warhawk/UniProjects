/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contextobjects;

import com.mycompany.cs4227.communication.framework.dialogs.OptionPaneFacade;

/**
 *
 * @author Rory
 */
public class InterceptOptions implements IContextObjects {

    private String contextText;

    public InterceptOptions(String text) {
        System.out.print("Option Intercepter engaged");
        this.contextText = text;
    }

    @Override
    public void createLog() {
        if (contextText.equalsIgnoreCase("usernameFormat")) {
            OptionPaneFacade.getInstance().showInputError();
        } else if (contextText.equalsIgnoreCase("valid")) {
            OptionPaneFacade.getInstance().showValid();
        } else if (contextText.equalsIgnoreCase("notFound")) {
            OptionPaneFacade.getInstance().notFound();
        }
    }

    @Override
    public String getTextString() {
        return contextText;
    }

    @Override
    public void setTextString(String newText) {
        this.contextText = newText;
    }

}
