package by.mitskevich.servicestation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ServiceStationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceStationApplication.class, args);
    }

}
