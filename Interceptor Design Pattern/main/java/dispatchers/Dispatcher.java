/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import contextobjects.IContextObjects;
import interceptors.Interceptor;
import java.util.ArrayList;

/**
 *
 * @author Alan
 */
public class Dispatcher {
    private ArrayList<Interceptor> localInter = new ArrayList<>();
    
    public void register(Interceptor interceptor, int position){
        System.out.println("Position in array" + position+"\n");
        localInter.add(position, interceptor);
        System.out.println("Interceptor registered with dispatcher\n");
    }
    
    public void unregister(int position){
        localInter.remove(position);
        System.out.println("Interceptor unregistered from dispatcher\n");
    }
    
    public void update(IContextObjects context, int interceptorPos){
        System.out.println("Update called on dispatcher");
        localInter.get(interceptorPos).update(context);        
    }
}
