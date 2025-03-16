package Func_Inter.JavaLib;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class HowSupplier {
    public static void main(String[] args) {
        var howWork = new HowSupplier();
        Supplier<List<Integer>> fiveInts = () -> {
            List<Integer> intList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                intList.add(getRandomNumber(0, 100));
            }
            return intList;
        };
        howWork.utilizeSupplier(fiveInts);
    }

    void utilizeSupplier(Supplier<List<Integer>> supplier) {
        System.out.println(supplier.get());
    }

    static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
