package pgk3hue_bsp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    int[] numbers = new int[1000];
    String[] random = new String[10];
    final char[] ZEICHEN = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y' + 'z'};

    public Streams() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        String var = "";
        for (int i = 0; i < random.length; i++) {
            for (int j = 0; j < 10; j++) {
                var += ZEICHEN[(int) (Math.random() * ZEICHEN.length)];
            }
            random[i] = var;
        }

        String[] randomS = new String[10];

        for (int i = 0; i < randomS.length; i++) {
            String tmp = "";
            int rnd = (int) Math.random() * ZEICHEN.length;
            for (int j = 0; j < 10; j++) {
                tmp = tmp + ZEICHEN[rnd];
            }
            randomS[i] = tmp;
        }

    }

    public double average(int[] numbers) {
        return Arrays.stream(numbers).average().orElseThrow();
    }

    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map(string -> string.toUpperCase()).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return weapons.stream().min(Comparator.comparingInt(w -> w.getDamage())).orElse(null);
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return weapons.stream().max(Comparator.comparingInt(w -> w.getMinStrength())).orElse(null);
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter((t) -> t.getDamageType() == DamageType.MISSILE).collect(Collectors.toList());

    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        return weapons.stream().max(Comparator.comparingInt(w -> w.getName().length())).orElse(null);
    }

    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream().map(Weapon::getName).collect(Collectors.toList());
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        List<Integer> speeds = weapons.stream().map(Weapon::getSpeed).collect(Collectors.toList());
        int[] intSpeeds = new int[speeds.size()];
        for (int i = 0; i < speeds.size(); i++) {
            Integer get = speeds.get(i);
            intSpeeds[i] = get;
        }
        return intSpeeds;
    }

    public int sumUpValues(List<Weapon> weapons) {
        int sum = weapons.stream().mapToInt(Weapon::getValue).sum();
        return sum;
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        long sum = weapons.stream().mapToInt(Weapon::hashCode).sum();
        return sum;
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream().distinct().collect(Collectors.toList());
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.stream().forEach(w
                -> {
            w.setValue((int) (w.getValue() * 1.1));
        });
    }
}
