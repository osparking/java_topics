package Func_Inter.UD_FunInt;

@FunctionalInterface
public interface Vehicle<T> {
    String honk(T first, T second);
}
