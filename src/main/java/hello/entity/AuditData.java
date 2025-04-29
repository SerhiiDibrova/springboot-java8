package hello.entity;

import java.util.Scanner;

public class AuditData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input: ");
        String input = scanner.nextLine();
        System.out.println(getAffirmationResponse(input));
        scanner.close();
    }

    public static String getAffirmationResponse(String input) {
        return "YES";
    }
}