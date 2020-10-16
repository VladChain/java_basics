
public class Loader {
    public static void main(String[] args) {
/*
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
*/

        // 4.1 Объекты и примитивы
//        Cat cat = new Cat();
//        Cat cat2 = cat;
//
//
//        System.out.println(cat.getWeight());
//        System.out.println(cat2.getWeight());
//
//        cat2.drink(100.0);
//
//        System.out.println(cat.getWeight());
//        System.out.println(cat2.getWeight());
//
//        int murkaAge = 25;
//        int vasyaAge = murkaAge;
//        vasyaAge++;
//        System.out.println(murkaAge);
//        System.out.println(vasyaAge);

//        Integer murkaAge = 26;
//        Integer vasyaAge = 24;
//
//        System.out.println(murkaAge > vasyaAge);
//        System.out.println(murkaAge.compareTo(vasyaAge));
//        System.out.println(murkaAge.equals(vasyaAge));
//        System.out.println(murkaAge == vasyaAge);    // Здесь происходит сравнение не возраста, а ссылок на объект.
//                                                     // Так сравнивать объкты нельзы для этого есть
//                                                     // методы .compareTo() и .equals
//
//        // 4.2 Зачем нужны объекты и примитивы
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.parseInt("548541")); // Преобразования строки в число
//
//        double digits[] = new double[4564864]; // С таким массивом легче работать и он будет меньше занимать
//        Double digit[] = new Double[4564864];  // места в памяти, чем

        // 4.3 Значения по умолчанию - printsreens, saved in my folder.
        // 4.4 Boxing и unboxing
        Integer age = 5; // Преобразование объекта в примитив называется "boxing"
        int barsicAge = 7;
        System.out.println(age < barsicAge); // В данном случае произойдет "unboxing". Значение age будет
                                             // превращено в примитив barsikAge, только потом произойдет сравнение.
        // "boxing" и "unboxing" - это автоматическое преобразование примитива в объект и обратно.

        System.out.println(compareIntegers(5, 5)); // Вызов метода compareIntegers
    }
    // e.g.
    private static boolean compareIntegers(Integer age1, Integer age2)
    {
        return age1.equals(age2);
    }
}