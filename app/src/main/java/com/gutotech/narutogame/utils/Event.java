package com.gutotech.narutogame.utils;

public class Event<T> {
    private T content;

    public Event(T content) {
        this.content = content;
    }

    private boolean hasBeenHandled = false;

    /**
     * Returns the content and prevents its use again.
     */
    public T getContentIfNotHandled() {
        if (hasBeenHandled) {
            return null;
        } else {
            hasBeenHandled = true;
            return content;
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    public T peekContent() {
        return content;
    }
}
