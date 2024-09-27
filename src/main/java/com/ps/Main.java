package com.ps;
 import java.text.DecimalFormat;
 import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static DecimalFormat format = new DecimalFormat("0.##");
    public static void main(String[] args) {

        System.out.println("Welcome to Calculator World," +
                " select one of the following numbers: " +
                "1) mortgage calculator, 2) future value calculator, 3) present annuity value calculator");
        if(scanner.nextInt() == 1){
            mortgageCalculator();
        }
    }

    public static void mortgageCalculator(){
        double principal;
        double interestRate;
        int loanDuration;

        System.out.println("Welcome to mortgage calculator");
        System.out.println("Please enter your principal: ");
        principal = scanner.nextDouble();
        System.out.println("Please enter the interest rate: ");
        interestRate = scanner.nextDouble();
        System.out.println("Enter the duration of the loan in years: ");
        loanDuration = scanner.nextInt();
        System.out.println(loanDuration);

        double monthlyRate = interestRate / 12 / 100;
        double loanInMonth = loanDuration * 12;
         double monthlyPayment =  principal *(monthlyRate/ (1 -(Math.pow(1 + monthlyRate, -loanInMonth))));
        //System.out.println(monthlyPayment);
        double totalInterest = monthlyPayment * loanInMonth - principal;
        String messageToUser = String.format("For a mortgage of %s, an interest rate of %s and a loan length of %s years. Your " +
                        "total monthly payment is $ %s and a total interest of %s"
                ,principal, interestRate, loanDuration, format.format(monthlyPayment), format.format(totalInterest));
        System.out.println(messageToUser);








    }
}