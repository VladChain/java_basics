
public class Main {

    public static final String MOVEMENT_LIST = "data/movementList.csv";

    public static void main(String[] args) {

        Movements movements = new Movements(MOVEMENT_LIST);
        System.out.println("Сумма расходов: " + movements.getExpenseSum() + " руб.");
        System.out.println("Сумма доходов: " + movements.getIncomeSum() + " руб.");
        System.out.println("Суммы расходов по организациям:\n"
                + movements.getSumExpenseCompanies());
    }
}
