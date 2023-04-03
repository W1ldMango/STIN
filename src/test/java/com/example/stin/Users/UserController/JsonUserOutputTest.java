package com.example.stin.Users.UserController;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.example.stin.Bank.Account.AccountEntity;
import com.example.stin.Bank.Account.AccountRepository;
import com.example.stin.Bank.Transaction.TransactionEntity;
import com.example.stin.Bank.Transaction.TransactionRepository;
import com.example.stin.Users.UserDetails.UserEntity;
import com.example.stin.Users.UserInterface.UserRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

//@WebMvcTest
//@ExtendWith(SpringExtension.class)
//@ImportResource(locations = {"classpath:webapp/WEB-INF/application-context.xml"})
@SpringBootTest
@AutoConfigureMockMvc
public class JsonUserOutputTest {
//
//    @Autowired
//    private JsonUserInfoOutput jsonUserInfoOutput;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @Test
//    @WithMockUser(username = "admin@gmail.com", password = "admin")
//    public void testJson() throws Exception {
//        this.mockMvc.perform(get("/json"))
//                .andExpect(status().isOk());
//    }
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private JsonUserInfoOutput jsonUserInfoOutput;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @MockBean
//    private AccountRepository accountRepository;
//
//    @MockBean
//    private TransactionRepository transactionRepository;
//
//    @Test
//    @WithMockUser(username = "test@example.com")
//    public void testJson() throws Exception {
//        String name = "John";
//        String surname = "Doe";
//        String email = "test@example.com";
//        long accountNumber = 1234567890L;
//        double balanceUSD = 1000.0;
//        double balanceEUR = 800.0;
//        double balanceCZK = 20000.0;
//
//        UserEntity user = new UserEntity();
//        user.setName(name);
//        user.setSurname(surname);
//        user.setEmail(email);
//
//        AccountEntity account = new AccountEntity();
//        account.setId(1L);
////        account.setUser(user);
//        account.setAccountNumber(accountNumber);
//        account.setBalanceUSD(balanceUSD);
//        account.setBalanceEUR(balanceEUR);
//        account.setBalanceCZK(balanceCZK);
//
//        List<TransactionEntity> transactions = new ArrayList<>();
//        TransactionEntity transaction1 = new TransactionEntity();
//        transaction1.setId(1L);
//        transaction1.setAccountNumber(accountNumber);
//        transaction1.setAmount(100.0);
//        transaction1.setCurrency("USD");
//        transactions.add(transaction1);
//
//        Mockito.when(userRepository.findByEmail(email)).thenReturn(user);
//        Mockito.when(accountRepository.findAllById(user.getId())).thenReturn(account);
//        Mockito.when(transactionRepository.findAllByUserId(accountNumber)).thenReturn(transactions);
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name", name);
//        jsonObject.put("surname", surname);
//        jsonObject.put("email", email);
//        jsonObject.put("accountNumber", accountNumber);
//        jsonObject.put("balanceUSD", balanceUSD);
//        jsonObject.put("balanceEUR", balanceEUR);
//        jsonObject.put("balanceCZK", balanceCZK);
//        jsonObject.put("transactions", transactions);
//
//        assertNotNull(jsonObject);
//
//        this.mockMvc.perform(get("/json"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(jsonObject.toString()));
//    }
}
