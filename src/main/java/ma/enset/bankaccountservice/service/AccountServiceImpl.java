package ma.enset.bankaccountservice.service;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.AllArgsConstructor;
import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponseDTO;
import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.mappers.AccountMapper;
import ma.enset.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Server
@Transactional
@AllArgsConstructor
@Component
public class AccountServiceImpl implements AccountService {

    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDto) {
        BankAccount bankAccount =  BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createAt(new Date())
                .type(bankAccountDto.getType())
                .balance(bankAccountDto.getBalance())
                .currency(bankAccountDto.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO=accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDto) {
        BankAccount bankAccount =  BankAccount.builder()
                .id(id)
                .createAt(new Date())
                .type(bankAccountDto.getType())
                .balance(bankAccountDto.getBalance())
                .currency(bankAccountDto.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO=accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
}
