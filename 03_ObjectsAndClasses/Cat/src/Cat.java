
public class Cat
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double amountFood;
    private static int count;
    private String name;
    private Color color;

    public static final int LEGS_COUNT = 4;
    public static final int EYES_COUNT = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        amountFood = 0;
        count ++;
    }

    public Cat(double weight, String name, Color color)
    {
        this.weight = weight;
        this.name = name;
        this.color = color;
    }

    public Cat(Double weight)
    {
        this.weight = weight;
    }

    public Cat(String name)
    {
        this();
        this.name = name;
    }

    public Cat(Color color)
    {
        this();
        this.color = color;
    }

    public Cat(Cat cat)
    {
        this(cat.getWeight(), cat.getName(), cat.getColor());
    }

    public void Copy(Cat cat)
    {
        setWeight(cat.getWeight());
        setName(cat.getName());
        setColor(cat.getColor());
    }


    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }

    public static int getCount()
    {
        return count;
    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        if (!getStatus().equals("Dead") && !getStatus().equals("Exploded"))
        {
            this.amountFood = amount;
            weight += amountFood;
            System.out.println("Feed");
            if (getStatus().equals("Exploded"))
                count--;
        }
        else
            System.out.println("Feed. U can't feed this cat more!");
    }

    public void pee()
    {
        weight = weight - amountFood;
        System.out.println("Pee");
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
        System.out.println("Drink");
    }

    public void setWeight(Double weight)
    {
        this.weight = weight;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight)
        {
            return "Dead";
        }
        else if(weight > maxWeight)
        {
            return "Exploded";
        }
        else if(weight > originWeight)
        {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}
