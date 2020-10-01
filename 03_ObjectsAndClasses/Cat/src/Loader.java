
public class Loader
{
    public static void main(String[] args)
    {
        System.out.println("Amount cats:" + Cat.getCount());
        System.out.println("Add cats: ...");

        Cat murka = new Cat();
        System.out.println("Murka weight:" + murka.getWeight());
/*
        while (murka.getStatus() != "Exploded")
        {
            murka.feed(10000.0);

            System.out.println("Murka weight:" + murka.getWeight());
            System.out.println("Murka status:" + murka.getStatus());
            System.out.println();
        }
*/
        Cat vasya = new Cat();
        System.out.println("Vasya weight:" + vasya.getWeight());
/*
        while (vasya.getStatus() != "Dead")
        {
            vasya.meow();

            System.out.println("Vasya weight:" + vasya.getWeight());
            System.out.println("Vasya status:" + vasya.getStatus());
            System.out.println();
        }
*/
        Cat barsik = new Cat();
        System.out.println("Barsik weight:" + barsik.getWeight());
/*
        barsik.feed(150.0);

        System.out.println("Barsik weight:" + barsik.getWeight());
        System.out.println();
*/
        Cat sonya = new Cat();
        System.out.println("Sonya weight:" + sonya.getWeight());
/*
        sonya.feed(100.0);

        System.out.println("Sonya weight:" + sonya.getWeight());
        System.out.println();
*/
        Cat tom = new Cat();
        System.out.println("Tom weight:" + tom.getWeight());
/*
        tom.feed(tom.getWeight());

        System.out.println("Tom weight:" + tom.getWeight());
        System.out.println("Tom status:" + tom.getStatus());

        tom.pee();
        tom.pee();
        tom.pee();

        System.out.println("Tom weight:" + tom.getWeight());
        System.out.println("Tom status:" + tom.getStatus());

        System.out.println("Sonya weight:" + sonya.getWeight());
        System.out.println("Sonya status:" + sonya.getStatus());
        System.out.println("Barsik weight:" + barsik.getWeight());
        System.out.println("Barsik status:" + barsik.getStatus());
        System.out.println("Vasya weight:" + vasya.getWeight());
        System.out.println("Vasya status:" + vasya.getStatus());
        System.out.println("Murka weight:" + murka.getWeight());
        System.out.println("Murka status:" + murka.getStatus());
*/
        System.out.println("Amount cats:" + Cat.getCount());

        murka.feed(10000.0);

        System.out.println("Murka weight:" + murka.getWeight());
        System.out.println("Murka status:" + murka.getStatus());

        System.out.println("Amount alive cats:" + Cat.getCount());

        murka.feed(1.0);

        System.out.println("Amount alive cats:" + Cat.getCount());
    }
}