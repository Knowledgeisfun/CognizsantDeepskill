package DatastructuresandAlgorithms.Exersice3;

public class RecursiveAlgo {
    public static void main(String[] args){
        double intialPortfolioValue = 100000.0;
        double expectedAnnualGrowth = 0.12;
        int yearsToForecast = 5;

        System.out.println("--- Recursive Financial Forecast ---");
        double futureValue = calculateFutureValue(intialPortfolioValue, expectedAnnualGrowth, yearsToForecast);

        System.out.printf("Projected Value after %d years: %.2f\n", yearsToForecast, futureValue);

    }

    public static double calculateFutureValue(double currentValue, double rate, int year){
        if(year == 0){
            return currentValue;
        }
        double nearYearValue = currentValue + (currentValue * rate);

        return calculateFutureValue(nearYearValue, rate, year-1);
    }


}
