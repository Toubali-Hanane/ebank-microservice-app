package ma.toubali.customerservice;

import ma.toubali.customerservice.entities.Customer;
import ma.toubali.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerService customerService){
        return args -> {
            List<String> names = List.of("Ahmed", "Hanane", "Malak");

            names.forEach(name -> {
                customerService.saveCustomer(Customer.builder()
                        .name(name)
                        .email(name + "@gmail.com")
                        .build());
            });
        };
    }

}
