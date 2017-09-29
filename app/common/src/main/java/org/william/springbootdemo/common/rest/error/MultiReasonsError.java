package org.william.springbootdemo.common.rest.error;

import java.util.List;

/**
 * Error with multiple reasons.
 *
 */
public final class MultiReasonsError extends RestError {

    private List<String> messages;

    public MultiReasonsError(Integer code, List<String> messages) {
        super(code);

        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Error:\n code: " + super.getCode() + "\n messages: " + messages;
    }

}
