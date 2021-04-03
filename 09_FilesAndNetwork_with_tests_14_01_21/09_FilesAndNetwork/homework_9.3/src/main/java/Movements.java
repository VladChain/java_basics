import java.io.IOException;;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Movements {

    private Map<String, Double> sum = new HashMap<String, Double>();

    private String pathMovementsCsv;

    private String descriptionOperation;
    private Double income;
    private Double expense;

    private Double sumExpenseCompanies;

    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
    }

//    public Movements(Double )

    private Movements(String descriptionOperation, Double income, Double expense) {
        this.descriptionOperation = descriptionOperation;
        this.income = income;
        this.expense = expense;
    }

    private List<Movements> loadMovementsFromFile() {
        List<Movements> movements = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(getPathMovementsCsv()));
            for (String line : lines) {
                String[] tempFragments = new String[2];
                try {
                    if (line.contains("\"")) {
                        tempFragments = line.split("\"");
                        tempFragments[1] = tempFragments[1].replace(",", ".");
                    }
                } catch (Exception e) {
                    System.out.println("Некорректная строка! " + line);
                }

                String[] fragments = line.split(",");
                try {
                    fragments[5] = fragments[5].replaceAll("\\\\", " ")
                            .substring(20, 60).trim();

                    if (fragments.length == 8) {
                        movements.add(new Movements(
                                fragments[5],
                                Double.parseDouble(fragments[6]),
                                Double.parseDouble(fragments[7])
                        ));
                    }
                    if (fragments.length == 9 && fragments[fragments.length - 1].equals("0")) {
                        movements.add(new Movements(
                                fragments[5],
                                Double.parseDouble(tempFragments[1]),
                                Double.parseDouble(fragments[8])
                        ));
                    } else {
                        movements.add(new Movements(
                                fragments[5],
                                Double.parseDouble(fragments[6]),
                                Double.parseDouble(tempFragments[1])
                        ));
                    }
                } catch (Exception ex) {
//                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return movements;
    }

    public double getExpenseSum() {
        double totalSum = 0;
        try {
            for (Movements rec : loadMovementsFromFile()) {
                totalSum += rec.getExpense();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return totalSum;
    }

    public Double getIncomeSum() {
        double totalSum = 0;
        try {
            for (Movements rec : loadMovementsFromFile()) {
                totalSum += rec.getIncome();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return totalSum;
    }

    public String getSumExpenseCompanies() {
        StringBuilder list = new StringBuilder();
        sumExpenseCompanies = 0.0;
        for (Movements m : loadMovementsFromFile()) {
            String key = m.getDescriptionOperation();
            if (m.getIncome() == 0.0) {
                sumExpenseCompanies = sum.containsKey(key) ? sum.get(key) : 0;
                sumExpenseCompanies += m.getExpense();
                sum.put(key, sumExpenseCompanies);
            }
        }
        for (String key : sum.keySet())
            list.append(key).append(": ").append(Math.abs(sum.get(key))).append(" руб.").append("\n");

        return list.toString();
    }

    private String getPathMovementsCsv() {
        return pathMovementsCsv;
    }

    private Double getIncome() {
        return income;
    }

    private Double getExpense() {
        return expense;
    }

    private String getDescriptionOperation() {
        return descriptionOperation;
    }
}


