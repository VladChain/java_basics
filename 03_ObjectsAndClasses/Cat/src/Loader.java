
public class Loader
{
    public static void main(String[] args)
    {

        Cat murka = new Cat();
        System.out.println("Murka weight:" + murka.getWeight());

        String murkaStatus = murka.getStatus();
        String murkaGetStatus = "Exploded";

        while (murka.getStatus() != "Exploded")
        {
            murka.feed();

            System.out.println("Murka weight:" + murka.getWeight());
            System.out.println("Murka status:" + murka.getStatus());
            System.out.println();
        }

        Cat vasya = new Cat();
        System.out.println("Vasya weight:" + vasya.getWeight());

        String vasyaStatus = vasya.getStatus();
        String vasyaGetStatus = "Dead";

        while (vasya.getStatus() != "Dead")
        {
            vasya.meow();

            System.out.println("Vasya weight:" + vasya.getWeight());
            System.out.println("Vasya status:" + vasya.getStatus());
            System.out.println();
        }

        Cat barsik = new Cat();
        System.out.println("Barsik weight:" + barsik.getWeight());

        barsik.feed();

        System.out.println("Barsik weight:" + barsik.getWeight());
        System.out.println();

        Cat sonya = new Cat();
        System.out.println("Sonya weight:" + sonya.getWeight());

        sonya.feed();

        System.out.println("Sonya weight:" + sonya.getWeight());
        System.out.println();

        Cat tom = new Cat();
        System.out.println("Tom weight:" + tom.getWeight());

        System.out.println("Sonya weight:" + sonya.getWeight());
        System.out.println("Barsik weight:" + barsik.getWeight());
        System.out.println("Vasya weight:" + vasya.getWeight());
        System.out.println("Vasya status:" + vasya.getStatus());
        System.out.println("Murka weight:" + murka.getWeight());
        System.out.println("Murka status:" + murka.getStatus());


    }
}