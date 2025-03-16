package Func_Inter.JavaLib;

import java.util.function.BiFunction;

public class HowBiFunWork {

    static BiFunction<String, String, String> snake = (meal, output) -> {
        return meal + " 을 먹고 " + output + "을 만든다";
    };

    static void proverbPrinter(BiFunction<String, String, String> biFunc,
                          String arg1, String arg2) {
        System.out.println(biFunc.apply(arg1, arg2));
    }

    public static void main(String[] args) {
        BiFunction<String, String, String> fun1 =
                (s, t) -> {return s + "를 먹고 " + t + "를 만든다";};
        proverbPrinter(fun1, "목초", "독");

        proverbPrinter((s, t) -> {return s + "는 " + t;},
                "현자", "문일지십");
    }
}
