/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dukescript.impl.events;

import net.java.html.js.JavaScriptBody;

/**
 *
 * @author antonepple
 */
public class Element {

    private Object delegate;

    private Element(Object jsObject) {
        this.delegate = jsObject;
    }

    public static Element getDocument() {
        return new Element(getDocument_impl());
    }

    public static Element getElementbyId(String id) {
        return new Element(getElementbyId(id));
    }
    
     Object getDelegate(){
        return delegate;
    }

    @JavaScriptBody(args = {}, body = "return document;")
    private static native Object getDocument_impl();

    @JavaScriptBody(args = {"id"}, body = "return document.getElementbyId(id);")
    private static native Object getDocument_impl(String id);

}
