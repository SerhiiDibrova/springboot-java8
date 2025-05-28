package hello;

import hello.controller.AtmController;
import hello.exceptions.InvalidArgumentException;
import hello.exceptions.InvalidNumberOfArgumentsException;

public class AtmApplication {

    public static void main(String[] args) {
        try {
            validateArguments(args);
            AtmController atmController = new AtmController();
            atmController.createAndRunAtm(args);
        } catch (InvalidNumberOfArgumentsException e) {
            System.out.println("Error: Invalid number of arguments. Please provide the correct number of arguments.");
        } catch (InvalidArgumentException e) {
            System.out.println("Error: Invalid argument. Please provide a valid argument.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void validateArguments(String[] args) {
        if (args.length < 1) {
            throw new InvalidNumberOfArgumentsException("At least one argument is required.");
        }
        for (String arg : args) {
            if (arg == null || arg.isEmpty()) {
                throw new InvalidArgumentException("Invalid argument. Argument cannot be null or empty.");
            }
        }
    }
}