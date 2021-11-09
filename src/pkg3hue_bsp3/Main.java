package pkg3hue_bsp3;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Predicate<Integer> isEven = (t) -> (t % 2 == 0);
        IntPredicate isPositiv = (t) -> (t > 0);
        Predicate<Integer> isNullInteger = (t) -> (t == 0);
        Predicate<Object> isNullObject = (o) -> (o == null);
        Predicate<String> isShort = (s) -> (s.length() < 4);

        Predicate<Integer> isEvenAndPositiv = isEven.and((Predicate<? super Integer>) isPositiv);
        Predicate<Integer> isNotEvenAndPositiv = isEven.negate().and((Predicate<? super Integer>) isPositiv);
    }
}
