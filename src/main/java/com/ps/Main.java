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
        int selection = scanner.nextInt();
        if(selection == 1){
            mortgageCalculator();
        } else if (selection == 2) {
            futureValueCalculator();
        } else if (selection == 3){
            presentValueCalculator();
        } else {
            System.out.println("invalid command");
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
    public static void  futureValueCalculator(){
        //System.out.println("Hello World");
        double deposit;
        double cdInterestRate;
        int maturity;

        System.out.println("Welcome to future value calculator!");

        System.out.println("Enter your Rate: ");
        cdInterestRate = scanner.nextDouble();
        double dailyRate = (cdInterestRate / 365) / 100;

        //System.out.println(dailyRate);

        System.out.println("Enter the maturity in years: ");
        maturity = scanner.nextInt();
        int maturityTimes_365 = maturity * 365;

        System.out.println("Enter the deposit amount: ");
        deposit = scanner.nextDouble();

        double futureValue = deposit * Math.pow(( 1 + dailyRate), maturityTimes_365);
        //System.out.println(futureValue); testing for future value
        double totalInterest = futureValue - deposit;
        //System.out.println(totalInterest); testing for total interest
        String messageToUser = String.format("If you deposit %s in a cd that earns %s percent interest and matures in %s years your cd's ending " +
                "balance would be %s and you would have earned %s ", deposit, cdInterestRate, maturity, format.format(futureValue), format.format(totalInterest));
        System.out.println(messageToUser);



    }
    public static void presentValueCalculator(){
        System.out.println("Hello world");
    }
}