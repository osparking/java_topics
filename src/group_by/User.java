package group_by;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private LocalDate createdAt;
    public String createdAtMonth() {
        int monInt = createdAt.getMonthValue();
        String monStr = String.format("%02d월", monInt);
        return monStr;
    }
    private String userType;
}
