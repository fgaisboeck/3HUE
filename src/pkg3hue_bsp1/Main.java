package pkg3hue_bsp1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Weapon> list = new LinkedList<>();
        // anonymous class for interface Comparator
        list.sort(new Comparator<Weapon>() {
            @Override
            public int compare(Weapon o1, Weapon o2) {
                return Integer.compare(o1.getDamage(), o2.getDamage());
            }
        });

        // lambda for interface Comparator
        list.clear();

        // reads a file in one line using lambdas
        list = Files.lines(new File("weapons.csv").toPath())
                .skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapon(
                s[0],
                CombatType.valueOf(s[1]),
                DamageType.valueOf(s[2]),
                Integer.parseInt(s[3]),
                Integer.parseInt(s[4]),
                Integer.parseInt(s[5]),
                Integer.parseInt(s[6])
        ))
                .collect(Collectors.toList());

        list.sort((w1, w2) -> Integer.compare(w1.getDamage(), w2.getDamage()));
        list.sort((w1, w2) -> w1.getDamageType().compareTo(w2.getDamageType()));
        list.sort((w1, w2) -> w1.getCombatType().compareTo(w2.getCombatType()));
        list.sort((w1, w2) -> w1.getName().compareTo(w2.getName()));

        // lambda for interface Runnable
//        Thread t = new Thread(() -> System.out.println("ID = " + Thread.currentThread().getId()));
//        t.start();
//
//        // more complex lambda for Runnable
//        new Thread(() -> {
//            while (true) {
//                System.out.println(new Date());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ex) {
//                    // do nothing
//                }
//            }
//        }).start();
        // lambda for functional interfaces
//        Function<Double, Integer> f = x -> x.intValue();
//        System.out.println("Function:       " + f.apply(47.11));
//        BinaryOperator<Integer> m = (x, y) -> x % y;
//        System.out.println("BinaryOperator: " + m.apply(5, 2));
//        Supplier<Integer> s = () -> (int) (Math.random() * 10);
//        System.out.println("Supplier:       " + s.get());
//        Predicate<Integer> p = x -> x < 10;
//        System.out.println("Predicate:      " + p.test(5));
//
//        // method reference for functional interface Consumer (alternative: lambda)
//        Consumer c = System.out::println; // (x) -> System.out.println(x);
//        c.accept("hello");
        // lambda for own functional interfaces
        Printable print = (weapons) -> {
            for (int i = 0; i < weapons.size(); i++) {
                System.out.println(weapons.get(i).toString());
            }
        };

        Printable printTabelle = (weapons) -> {
            int maxLength = 7;
            for (int i = 0; i < weapons.size(); i++) {
                if (weapons.get(i).getName().length() > maxLength) {
                    maxLength = weapons.get(i).getName().length();
                }
            }

            for (int i = 0; i < weapons.size(); i++) {
                String name = weapons.get(i).getName();
                while (maxLength != name.length()) {
                    name += " ";
                }
                String combatype = weapons.get(i).getCombatType().toString();
                while (maxLength != combatype.length()) {
                    combatype += " ";
                }
                String damagetype = weapons.get(i).getDamageType().toString();
                while (maxLength != damagetype.length()) {
                    damagetype += " ";
                }
                String damage = String.valueOf(weapons.get(i).getDamage());
                while (maxLength != damage.length()) {
                    damage += " ";
                }
                System.out.println("-----------------+-----------------+-----------------+-----------------+");
                System.out.print(name + "|");
                System.out.print(combatype + "|");
                System.out.print(damagetype + "|");
                System.out.print(damage + "|");
                System.out.println("");
            }
        };
        printTabelle.print(list);
    }
}
