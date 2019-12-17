package lesson15_16_17;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private final Long id;
    private final String name;
    private final Date birthday;
    private final Integer login_id;
    private final String city;
    private final String email;
    private final String descr;
}
