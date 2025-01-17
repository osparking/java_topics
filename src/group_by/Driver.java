package group_by;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Driver {
    private static List<User> getDummyUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User(1, LocalDate.of(2024, 11, 10), "VET"));
        users.add(new User(2, LocalDate.of(2024, 12, 10), "PATIENT"));
        users.add(new User(3, LocalDate.of(2024, 12, 10), "VET"));
        users.add(new User(4, LocalDate.of(2024, 12, 10), "PATIENT"));
        users.add(new User(5, LocalDate.of(2025, 1, 10), "VET"));
        users.add(new User(6, LocalDate.of(2025, 1, 10), "PATIENT"));
        users.add(new User(7, LocalDate.of(2025, 1, 10), "PATIENT"));
        users.add(new User(8, LocalDate.of(2025, 1, 10), "PATIENT"));
        users.add(new User(9, LocalDate.of(2025, 1, 10), "VET"));
        return users;
    }

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.byUserType();
        driver.byMonthString();
        driver.getMonthKo();
        driver.getMonthKo01월();
        driver.byMonthKo01월();
        driver.byMonthAndType();
    }

    // 예상 결과 - vet: 4, patient: 5
    void byUserType() {
        List<User> users = getDummyUsers();
        Map<String, Long> result = users.stream().collect(
                Collectors.groupingBy(User::getUserType, Collectors.counting()));
        System.out.println(result);
    }

    // 12월: 3, 1월: 5, ...
    void byMonthString() {
        List<User> users = getDummyUsers();
        Map<String, Long> result = users.stream().collect(
                Collectors.groupingBy(
                        (user) -> Month.of(user.getCreatedAt().getMonthValue())
                                .getDisplayName(TextStyle.FULL, Locale.KOREAN),
                        Collectors.counting()));
        System.out.println(result);
    }

    // 11월, ... , 1월, ...
    void getMonthKo() {
        List<User> users = getDummyUsers();
        List<String> months = users.stream().map(
                (user) -> Month.of(user.getCreatedAt().getMonthValue())
                        .getDisplayName(TextStyle.FULL, Locale.KOREAN))
                .toList();
        System.out.println(months);
    }

    // 11월, ... , 01월, ...
    void getMonthKo01월() {
        List<User> users = getDummyUsers();
        var months = users.stream().map(
                (user) -> {
                    int monInt = user.getCreatedAt().getMonthValue();
                    String monStr = String.format("%02d월", monInt);
                    return monStr;
                }).toList();
        System.out.println(months);
    }

    // 01월: 5, ...
    void byMonthKo01월() {
        List<User> users = getDummyUsers();
        Map<String, Long> result = users.stream().collect(
                Collectors.groupingBy(User::createdAtMonth, Collectors.counting()));
        System.out.println(result);
    }

    // 01월 : {vet: 2, patient: 3}, ...
    void byMonthAndType() {
        List<User> users = getDummyUsers();
        var result = users.stream().collect(
                Collectors.groupingBy(User::createdAtMonth,
                Collectors.groupingBy(User::getUserType,
                        Collectors.counting())));
        System.out.println(result);
    }

}
