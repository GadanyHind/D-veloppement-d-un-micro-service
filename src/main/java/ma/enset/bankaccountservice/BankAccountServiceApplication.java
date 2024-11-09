package ma.enset.bankaccountservice;

import ma.enset.bankaccountservice.entities.Customer;
import ma.enset.bankaccountservice.enums.AccountType;
import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.repositories.BankAccountRepository;
import ma.enset.bankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication

public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {

            Stream.of("Hind","Wissal","Khadija", "Hassan").forEach(c->{
                Customer customer =Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(c->{
                for (int i=0; i<10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                            .balance(29900+Math.random()*100000)
                            .createAt(new Date())
                            .currency("MAD")
                            .customer(c)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });

        };

    }
}
