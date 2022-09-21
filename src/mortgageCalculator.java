import java.util.IllegalFormatPrecisionException;
import java.util.Scanner;

public class mortgageCalculator {
    public static void main(String [] arg) {

        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENTAGE = 100;
        int AMOUNT = 0;
        float INTEREST = 0;
        byte PEROID = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            //The Principal(P)
            System.out.print("ENTER A VALID AMOUNT BETWEEN $1K AND $1M: ");
            AMOUNT = sc.nextInt();
            if (AMOUNT >= 1000 && AMOUNT <= 10000000)
                break;
        }

        Float annualInterestRate;
        while (true) {
            //Annual interest rate
            System.out.print("ENTER A VALID INTEREST RATE BETWEEN 1 AND 30: ");
            INTEREST = sc.nextFloat();
            annualInterestRate = INTEREST / PERCENTAGE / MONTHS_IN_YEARS;
            if (INTEREST > 0&& INTEREST<=30)
                break;
        }

        int numberOfPayment;
        while (true) {
            //LOAN PERIOD IN YEARS
            System.out.print("ENTER LOAN PERIOD BETWEEN ONE AND 30 IN YEARS: ");
            PEROID = sc.nextByte();
            numberOfPayment = PEROID * MONTHS_IN_YEARS;
            if (PEROID >= 1 && PEROID <= 30)
                break;
        }
        //MORTGAGE AMOUNT TO BE PAID
        double MORTGAGE = AMOUNT * annualInterestRate * (Math.pow((1 + annualInterestRate), numberOfPayment) / (Math.pow((1 + annualInterestRate), numberOfPayment) - 1));
        double MonthlyPaymentPlan = (double) (Math.round(MORTGAGE * 100.0) / 100.0);
        System.out.print("Mortgage:" + "  " + "$" + MonthlyPaymentPlan);
    }
}

