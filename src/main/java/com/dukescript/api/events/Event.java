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

/**
 * A simple Event with a type and a Source.
 * @author antonepple
 */
public class Event<T> {

    private final Type type;
    private final T source;
    public static Type ANY = new Type("Event", null);

    public Event(T source, Type type) {
        this.type = type;
        this.source = source;
    }

    /**
     * Get the source of the Event. The source is typically set once via EventSource 
     * create method.
     * @return 
     */
    public T getSource() {
        return source;
    }

    /**
     * The type of this Event, for example MouseEvent.MOUSE_PRESSED. Events 
     * are always dispatched for their Type and also all supertypes.
     * @return 
     */
    public Type getType() {
        return type;
    }

    /**
     * Event Type allows to build a hierarchy of events. E.g. the supertype of
     * MouseEvent.MOUSE_PRESSED is MouseEvent.ANY.
     * @param <T> 
     */
    public static class Type<T extends Event> {

        private final String name;
        private final Type superType;

        /**
         * Create anew Type with name and supertype.
         * @param name
         * @param superType 
         */
        public Type(String name, Type superType) {
            this.name = name;
            this.superType = superType;
        }

        /**
         * Name of this Event Type
         * @return 
         */
        public String getName() {
            return name;
        }

        /**
         * Super Type of this Event Type.
         * @return 
         */
        public Type getSuperType() {
            return superType;
        }

    }

}
