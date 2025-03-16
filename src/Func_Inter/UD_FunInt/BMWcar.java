package Func_Inter.UD_FunInt;

import java.util.function.BiFunction;

public class BMWcar {
    public static void main(String[] args) {
        Vehicle<String> vehicle = (first, last) -> {
            return first + last + "의 차가 빵빵한다.";
        };
        String state = vehicle.honk("범", "타이거");
        System.out.println(state);
    }
}