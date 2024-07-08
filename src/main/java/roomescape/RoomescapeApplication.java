package roomescape;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"roomescape", "auth"})
public class RoomescapeApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoomescapeApplication.class, args);
    }
}
