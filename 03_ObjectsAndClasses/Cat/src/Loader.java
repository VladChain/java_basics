
public class Loader {
    public static void main(String[] args) {

        System.out.println("Amount cats:" + Cat.getCount());
        System.out.println("Add cats: ...");
        System.out.println();


        Cat murka = new Cat(1000.0, "Murka", Color.RED);

        System.out.println(murka.getWeight());
        System.out.println(murka.getName());
        System.out.println("Murka's color: " + murka.getColor());

        while (murka.getStatus() != "Exploded") {
            murka.feed(10000.0);

            System.out.println("Murka weight:" + murka.getWeight());
            System.out.println("Murka status:" + murka.getStatus());
            System.out.println();
        }

        Cat vasya = new Cat();
        System.out.println("Vasya weight:" + vasya.getWeight());

        while (vasya.getStatus() != "Dead") {
            vasya.meow();

            System.out.println("Vasya weight:" + vasya.getWeight());
            System.out.println("Vasya status:" + vasya.getStatus());
            System.out.println();
        }

        Cat barsik = new Cat();
        System.out.println("Barsik weight:" + barsik.getWeight());

        barsik.feed(150.0);

        System.out.println("Barsik weight:" + barsik.getWeight());
        System.out.println();


        Cat sonya = new Cat();
        System.out.println("Sonya weight:" + sonya.getWeight());

        sonya.feed(100.0);

        System.out.println("Sonya weight:" + sonya.getWeight());
        System.out.println();


        Cat tom = new Cat();
        System.out.println("Tom weight:" + tom.getWeight());

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
        System.out.println();


        System.out.println("Amount cats:" + Cat.getCount());

        Cat kuzya = new Cat();
        kuzya.feed(10000.0);

        System.out.println("Kuzya weight:" + kuzya.getWeight());
        System.out.println("Kuzya status:" + kuzya.getStatus());

        System.out.println("Amount alive cats:" + Cat.getCount());

        kuzya.feed(1.0);

        System.out.println("Amount alive cats:" + Cat.getCount());
        System.out.println();


        Cat pushok = getKitten();
        System.out.println("Weight pushok: " + pushok.getWeight());

        Cat snejok = getKitten();
        System.out.println("Weight snejok: " + snejok.getWeight());

        Cat kolobok = getKitten();
        System.out.println("Weight kolobok: " + kolobok.getWeight());
        System.out.println();


        Cat rokki = new Cat(1500.0, "Rokki", Color.STRIPED);

        Cat atos = new Cat(rokki);
        System.out.println("Cat Atos: " + atos.getWeight() + ", " + atos.getName() + ", " + atos.getColor());

        Cat casper = new Cat();
        casper.Copy(rokki);
        System.out.println("Cat Casper: " + casper.getWeight() + ", " + casper.getName() + ", " + casper.getColor());
        System.out.println("Yeah, dude! Good job! Well done! Thanks God & my teacher Ruslan!))");
    }
    private static Cat getKitten() {
        return new Cat(1100.0);
    }
}