package com.dukescript.api.events;

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
import com.dukescript.impl.events.EventManager;
import com.dukescript.impl.events.EventRegistration;

/**
 * EventSource is your entry point to DukeScript Events. Simply create a new one
 * using the create factory method passing in the id of the HTML-element you'd
 * like to receive events from and an arbitrary object, which can then be used
 * as the source of the events. A typical use case would be to use with the
 * canvas API:
 *
 * <pre>
 * {@code
 * GraphicsContext2D ctx = GraphicsContext2D.getOrCreate("canvas");
 * EventSource es = EventSource.create(ctx, "canvas");
 * es.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
 *   @Override
 *   public void handle(MouseEvent event) {
 *     GraphicsContext2D g2d = (GraphicsContext2D) event.getSource();
 *     g2d.setFillStyle(ctx.getWebColor("orange"));
 *     g2d.fillCircle((float) event.getX(), (float) event.getY(), 10);
 *   }
 * });
 * }
 * </pre>
 *
 * Then add your EventHandlers there and receive Events.
 *
 * @author antonepple
 */
public abstract class EventSource<S> {

    /**
     * Add an EventHandler to this EventSource to receive Events of the
     * specified type.
     *
     * @param <T>
     * @param type
     * @param handler
     */
    public abstract <T extends Event> void addEventHandler(Event.Type<T> type, EventHandler<T> handler);

    /**
     * Remove the EventHandler
     *
     * @param <T>
     * @param type
     * @param handler
     */
    public abstract <T extends Event> void removeEventHandler(Event.Type<T> type, EventHandler<T> handler);

    /**
     * Create a new EventSource for the HTML Elemnt identified by the id and 
     * pass an object, which will be used as the source in any Event. Typically 
     * the source is an object that represents the element, like a GraphicsContext
     * in case of a Canvas. 
     *
     * @param <S>
     * @param source
     * @param id
     * @return
     */
    public static <S> EventSource create(S source, String id) {
        EventManager<S> eventManager = new EventManager<S>(source, id);
        EventRegistration.registerKeyEvents(eventManager, id);
        EventRegistration.registerMouseEvents(eventManager, id);
        EventRegistration.registerTouchEvents(eventManager, id);
        return eventManager;
    }

}
