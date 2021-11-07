package pgk3hue_bsp3;

import java.util.Arrays;
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
    }

    public double average(int[] numbers) {
        return Arrays.stream(numbers).average().orElseThrow();
    }

    public List<String> upperCase(String[] strings) {

        return null;
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return null;
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return null;
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return null;
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        return null;
    }

    public List<String> toNameList(List<Weapon> weapons) {
        return null;
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        return null;
    }

    public int sumUpValues(List<Weapon> weapons) {
        return 2;
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        return 2;
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return null;
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
    }
}
