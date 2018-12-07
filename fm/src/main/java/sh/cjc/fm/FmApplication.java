package sh.cjc.fm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@EnableTransactionManagement /**事务*/
public class FmApplication {
    public static void main(String[] args) {
        SpringApplication.run(FmApplication.class, args);
    }
}
