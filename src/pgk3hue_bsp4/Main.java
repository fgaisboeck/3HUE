package pgk3hue_bsp4;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        final int result = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(t -> t % 2 != 0).map(t -> t * t).reduce(0, (b1, b2) -> b1 + b2);
        System.out.println(result);
    }
}
