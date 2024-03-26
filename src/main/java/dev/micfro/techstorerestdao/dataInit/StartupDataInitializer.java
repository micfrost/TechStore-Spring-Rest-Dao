package dev.micfro.techstorerestdao.dataInit;

import dev.micfro.techstorerestdao.model.Customer;
import dev.micfro.techstorerestdao.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupDataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CustomerServiceInterface customerService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            // Initialize your data here
            Customer customer1 = new Customer("julianfrost");
            customerService.saveCustomer(customer1);
        }
    }
}
