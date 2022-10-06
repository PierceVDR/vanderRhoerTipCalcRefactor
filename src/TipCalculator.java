public class TipCalculator {
    int people; // numPeople
    double tipP; // tipPercentage
    double totalNoTip; // totalBillBeforeTip

    // Constructor:
    public TipCalculator(int numPeople, double tipPercentage) {
        people = numPeople;
        tipP = tipPercentage;
        totalNoTip = 0;
    }

    // Getter Methods:
    public double getTotalBillBeforeTip() {
        return totalNoTip;
    }

    public double getTipPercentage() {
        return tipP;
    }

    // Calculation Methods:
    public void addMeal(double cost) {
        totalNoTip+=cost;
    }

    public double tipAmount() {
        return totalNoTip * tipP/100;
    }

    public double totalBill() {
        return totalNoTip + tipAmount();
    }

    public double perPersonCostBeforeTip() {
        return totalNoTip/people;
    }

    public double perPersonTipAmount() {
        return tipAmount()/people;
    }

    public double perPersonTotalCost() {
        return totalBill()/people;
    }
}
