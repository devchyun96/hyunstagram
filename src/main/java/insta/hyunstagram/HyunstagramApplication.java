package insta.hyunstagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class HyunstagramApplication {

    public static void main(String[] args) {
        SpringApplication.run(HyunstagramApplication.class, args);
    }

}
