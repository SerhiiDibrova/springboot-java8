

package hello.dto;

import java.io.Serializable;

/**
 * Data Transfer Object for Proc35Request.
 */
public class Proc35RequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Input field of type Integer.
     */
    private Integer input;

    /**
     * Default constructor.
     */
    public Proc35RequestDTO() {}

    /**
     * Constructor with input field.
     * @param input Input field of type Integer.
     */
    public Proc35RequestDTO(Integer input) {
        this.input = input;
    }

    /**
     * Gets the input field.
     * @return Input field of type Integer.
     */
    public Integer getInput() {
        return input;
    }

    /**
     * Sets the input field.
     * @param input Input field of type Integer.
     */
    public void setInput(Integer input) {
        this.input = input;
    }
}