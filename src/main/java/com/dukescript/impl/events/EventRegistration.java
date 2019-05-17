package com.dukescript.impl.events;

/*-
 * #%L
 * events - a library from the "DukeScript" project.
 * %%
 * Copyright (C) 2016 - 2018 Dukehoff GmbH
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */
import net.java.html.js.JavaScriptBody;

/**
 *
 * @author antonepple
 */
public class EventRegistration {

    @JavaScriptBody(args = {"toolkit", "e"}, javacall = true, body
            = "e.addEventListener('touchstart',function (event) {"
            + "   event.preventDefault();\n"
            + "   var touches = event.touches;\n"
            + "   var result = []; "
            + "   var rect = e.getBoundingClientRect();"
            + "   for (var i = 0, l = touches.length; i < l; ++i) {\n"
            + "       result [i*2] = touches[i].clientX - rect.left ;\n"
            + "       result[(i*2)+1] = touches[i].clientY - rect.top;"
            + "   }\n"
            + "  if(result.length>0) {toolkit.@com.dukescript.impl.events.EventManager::touchStarted([Ljava/lang/Object;)(result);}\n"
            + "});"
            + "e.addEventListener('touchmove',function (event) {\n"
            + "   event.preventDefault();\n"
            + "   var touches = event.touches;\n"
            + "   var result = []; "
            + "   var rect = e.getBoundingClientRect();"
            + "   for (var i = 0, l = touches.length; i < l; ++i) {\n"
            + "       result [i*2] = touches[i].clientX - rect.left;\n"
            + "       result[(i*2)+1] = touches[i].clientY - rect.top;"
            + "   }\n"
            + "  if(result.length>0) {toolkit.@com.dukescript.impl.events.EventManager::touchMove([Ljava/lang/Object;)(result);}\n"
            + "});"
            + "e.addEventListener('touchend',function (event) {\n"
            + "   var touches = event.touches;\n"
            + "   var result = []; "
            + "   var rect = e.getBoundingClientRect();"
            + "   for (var i = 0, l = touches.length; i < l; ++i) {\n"
            + "       result [i*2] = touches[i].clientX - rect.left;\n"
            + "       result[(i*2)+1] = touches[i].clientY - rect.top;"
            + "   }\n"
            + "  if(result.length>0) {toolkit.@com.dukescript.impl.events.EventManager::touchEnd([Ljava/lang/Object;)(result);}\n"
            + "});"
            + "e.addEventListener('touchcancel',function (event) {\n"
            + "   event.preventDefault();\n"
            + "   var touches = event.touches;\n"
            + "   var result = []; "
            + "   var rect = e.getBoundingClientRect();"
            + "   for (var i = 0, l = touches.length; i < l; ++i) {\n"
            + "       result [i*2] = touches[i].clientX - rect.left;\n"
            + "       result[(i*2)+1] = touches[i].clientY - rect.top;"
            + "   }\n"
            + "  if(result.length>0) {toolkit.@com.dukescript.impl.events.EventManager::touchCancel([Ljava/lang/Object;)(result);}\n"
            + "});"
    )
    public static native void registerTouchEvents_impl(EventManager toolkit, Object e);

    @JavaScriptBody(args = {"toolkit", "e"}, javacall = true, body
            =  "e.addEventListener('mousedown', function (event) {\n"
            + "    var rect = e.getBoundingClientRect();"
            + "    var realX = event.clientX - rect.left;"
            + "    var realY = event.clientY - rect.top;"
            + "    toolkit.@com.dukescript.impl.events.EventManager::mouseDown(II)(realX, realY);"
            + "});\n"
            + "e.addEventListener('mousemove', function (event) {\n"
            + "    var rect = e.getBoundingClientRect();"
            + "    var realX = event.clientX - rect.left;"
            + "    var realY = event.clientY - rect.top;"
            + "    toolkit.@com.dukescript.impl.events.EventManager::mouseMoved(II)(realX, realY);"
            + "});\n"
            + "e.addEventListener('click',function (event) {\n"
            + "  var rect = e.getBoundingClientRect();"
            + "  var realX = event.clientX - rect.left;"
            + "  var realY = event.clientY - rect.top;"
            + "  toolkit.@com.dukescript.impl.events.EventManager::mouseClick(II)(realX, realY);"
            + "});\n"
            + "e.addEventListener('mouseup',function (event) {\n"
            + "  var rect = e.getBoundingClientRect();"
            + "  var realX = event.clientX - rect.left;"
            + "  var realY = event.clientY - rect.top;"
            + "  toolkit.@com.dukescript.impl.events.EventManager::mouseUp(II)(realX, realY);"
            + "});\n"
            + "e.addEventListener('mouseenter',function (event) {\n"
            + "  var rect = e.getBoundingClientRect();"
            + "  var realX = event.clientX - rect.left;"
            + "  var realY = event.clientY - rect.top;"
            + "  toolkit.@com.dukescript.impl.events.EventManager::mouseEntered(II)(realX, realY);"
            + "});\n"
            + "e.addEventListener('mouseleave',function (event) {\n"
            + "  var rect = e.getBoundingClientRect();"
            + "  var realX = event.clientX - rect.left;"
            + "  var realY = event.clientY - rect.top;"
            + "  toolkit.@com.dukescript.impl.events.EventManager::mouseExited(II)(realX, realY);"
            + "});\n"
    )
    public static native void registerMouseEvents_impl(EventManager toolkit, Object e);

    @JavaScriptBody(args = {"toolkit", "e"}, javacall = true, body
            = "e.addEventListener('keypress', function (event) {\n"
            + "  toolkit.@com.dukescript.impl.events.EventManager::keyPress(I)(event.keyCode);"
            + "});\n"
            + "e.addEventListener('keyup', function (event) {\n"
            + "  toolkit.@com.dukescript.impl.events.EventManager::keyUp(I)(event.keyCode);"
            + "});\n"
            + "e.addEventListener('keydown', function (event) {\n"
            + "  toolkit.@com.dukescript.impl.events.EventManager::keyDown(I)(event.keyCode);"
            + "});\n"
    )
    public static native void registerKeyEvents_impl(EventManager toolkit, Object e);

    public static <S> void registerKeyEvents(EventManager<S> eventManager, Element e) {
        registerKeyEvents_impl(eventManager, e.getDelegate());
    }

    public static <S> void registerMouseEvents(EventManager<S> eventManager, Element e) {
        registerMouseEvents_impl(eventManager, e.getDelegate());
    }

    public static <S> void registerTouchEvents(EventManager<S> eventManager, Element e) {
        registerTouchEvents_impl(eventManager, e.getDelegate());
    }
}
