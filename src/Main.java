import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Utility Vars
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);
        // Principal
        int principal;
        do {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if(principal <= 0) System.out.println("Please enter a valid Number");
        } while(principal <= 0);
        // Annual Interest
        float annualInterest;
        do {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if(annualInterest <= 0) System.out.println("Please enter a valid Number");
        } while(annualInterest <= 0);
        // Monthly Interest
        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;
        // Period (Years)
        byte years;
        do {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if(years <= 0) System.out.println("Invalid Years");
        } while(years <= 0);
        // Payments
        int numberOfPayments = years * MONTH_IN_YEAR;
        // Calculate Mortgage
        double mortgage = principal *
                (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        // Output Format
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }
}