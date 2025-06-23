package hello;

import hello.model.Customer;
import hello.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        CustomerService customerService = ctx.getBean(CustomerService.class);
        Customer customer = customerService.method_c();
        System.out.println(customer.toString());
    }
}