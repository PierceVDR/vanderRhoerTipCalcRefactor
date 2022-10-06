import java.text.DecimalFormat;
import java.util.Scanner;

public class TipCalculatorRunner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.##");

        // Welcome message:
        System.out.println("\nWelcome to my tip calculator!");

        System.out.println("-----------------------------------------------");
        // Getting info + Creating TipCalculator object:

        System.out.print("Enter the number of people in your group: ");
        int people = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter the tip percentage (100 = 100%): ");
        TipCalculator calc = new TipCalculator( people, scan.nextDouble() ); // Avoided creating another variable by integrating nextDouble into creating calc
        scan.nextLine();

        while (true) { // Gets costs and calculates sum until -1 entered
            System.out.print("Enter a cost, or -1 to indicate all costs have been entered: $");
            double cost = scan.nextDouble();
            scan.nextLine();

            if (cost==-1) {break;}

            calc.addMeal(cost);
        }

        scan.close();

        System.out.println("-----------------------------------------------");
        // Calculating & printing:

        System.out.println("Total Bill Before Tip: $" + formatter.format( calc.totalNoTip ));
        System.out.println("Tip Percentage: " + calc.getTipPercentage() + "%");
        System.out.println("Total Tip: $" + formatter.format( calc.tipAmount() ));
        System.out.println("Total Bill With Tip: $" + formatter.format( calc.totalBill() ) + "\n"); // Line break included here

        System.out.println("Bill Before Tip, Per Person: $" + formatter.format( calc.perPersonCostBeforeTip() ));
        //System.out.println("Tip Percentage, Per Person: " + Math.round(tipP/people*100)/100.0 + "%");
        System.out.println("Tip, Per Person: $" + formatter.format( calc.perPersonTipAmount() ));
        System.out.println("Bill With Tip, Per Person: $" + formatter.format( calc.perPersonTotalCost() ));
    }
}