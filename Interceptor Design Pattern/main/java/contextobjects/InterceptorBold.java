/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contextobjects;

/**
 *
 * @author Alan
 */
public class InterceptorBold implements IContextObjects{

    private String contextText;
  
    InterceptorBold(String text) {
        this.contextText = text;
    }

    @Override
    public void createLog() {
        /**
         * Required by the interface but not used for this context object
         */
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
