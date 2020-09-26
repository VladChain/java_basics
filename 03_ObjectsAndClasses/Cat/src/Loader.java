
public class Loader
{
    public static void main(String[] args)
    {
/*
        Cat murka = new Cat();
        System.out.println("Murka weight:" + murka.getWeight());

        while (murka.getStatus() != "Exploded")
        {
            murka.feed(murka.getWeight()*1);

            System.out.println("Murka weight:" + murka.getWeight());
            System.out.println("Murka status:" + murka.getStatus());
            System.out.println();
        }

        Cat vasya = new Cat();
        System.out.println("Vasya weight:" + vasya.getWeight());

        while (vasya.getStatus() != "Dead")
        {
            vasya.meow();

            System.out.println("Vasya weight:" + vasya.getWeight());
            System.out.println("Vasya status:" + vasya.getStatus());
            System.out.println();
        }

        Cat barsik = new Cat();
        System.out.println("Barsik weight:" + barsik.getWeight());

        barsik.feed(barsik.getWeight()+5);

        System.out.println("Barsik weight:" + barsik.getWeight());
        System.out.println();

        Cat sonya = new Cat();
        System.out.println("Sonya weight:" + sonya.getWeight());

        sonya.feed(sonya.getWeight()+10);

        System.out.println("Sonya weight:" + sonya.getWeight());
        System.out.println();
*/
        Cat tom = new Cat();
        System.out.println("Tom weight:" + tom.getWeight());

        tom.amountFood();
        tom.feed();

        System.out.println("Tom weight:" + tom.getWeight());
        System.out.println("Tom status:" + tom.getStatus());

        tom.pee();
        tom.pee();
        tom.pee();

        System.out.println("Tom weight:" + tom.getWeight());
        System.out.println("Tom status:" + tom.getStatus());

/*
        System.out.println("Sonya weight:" + sonya.getWeight());
        System.out.println("Barsik weight:" + barsik.getWeight());
        System.out.println("Vasya weight:" + vasya.getWeight());
        System.out.println("Vasya status:" + vasya.getStatus());
        System.out.println("Murka weight:" + murka.getWeight());
        System.out.println("Murka status:" + murka.getStatus());
*/

    }
}