package core;

public class Car
{
    private String number;
    private int height;
    private double weight;
    private boolean hasVehicle;
    private boolean isSpecial;

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setHasVehicle(boolean hasVehicle) {
        this.hasVehicle = hasVehicle;
    }

    public boolean isHasVehicle() {
        return hasVehicle;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}