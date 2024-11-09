package ma.enset.bankaccountservice.service;

import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {

     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDto);
     BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDto);
}
