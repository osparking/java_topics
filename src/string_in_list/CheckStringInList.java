package string_in_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckStringInList {
    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "cherry", "date", "elderberry"};
        List<String> list = Arrays.asList(arr);
        String target = "banana";
        System.out.println(list.contains(target));
    }
}
