/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import contextobjects.IContextObjects;

/**
 *
 * @author Alan
 */
public interface Interceptor {
    public void update(IContextObjects context);
}
