package com.example.Customer.CustomerRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerRepoApplication {

	private static final Logger log = LoggerFactory.getLogger(CustomerRepoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CustomerRepoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository) {
		return (args -> {
			customerRepository.save(new Customer("kumar", "Hari"));
			customerRepository.save(new Customer("sankar", "Hari"));
			customerRepository.save(new Customer("thangam", "Hari"));

			log.info("All Customers");
			log.info("--------------");
			for(Customer customer: customerRepository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			log.info("First Customer");
			log.info("-----------------");
			log.info(customerRepository.findById(1L).toString());
			log.info("");

			log.info("Customers with lastName as Hari");
			log.info("--------------------");
			for (Customer customer: customerRepository.findByLastName("Hari")) {
				log.info(customer.toString());
			}
			log.info("");
		});
	}

}
