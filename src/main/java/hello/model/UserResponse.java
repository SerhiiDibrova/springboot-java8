package hello.model;

import hello.model.User;

/**
 * Represents the response data for the UserAssociatedValueController class.
 * 
 * @author [Your Name]
 */
public class UserResponse {

    /**
     * The user object.
     */
    private User user;

    /**
     * Constructs a new UserResponse object with the given user.
     * 
     * @param user the user object
     * @throws NullPointerException if the user object is null
     */
    public UserResponse(User user) {
        if (user == null) {
            throw new NullPointerException("User object cannot be null");
        }
        this.user = user;
    }

    /**
     * Gets the user object.
     * 
     * @return the user object
     */
    public User getUser() {
        return user;
    }
}