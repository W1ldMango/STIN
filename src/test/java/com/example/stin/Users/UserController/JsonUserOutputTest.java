package com.example.stin.Users.UserController;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.stin.Bank.Account.AccountEntity;
import com.example.stin.Bank.Account.AccountRepository;
import com.example.stin.Bank.Transaction.TransactionEntity;
import com.example.stin.Bank.Transaction.TransactionRepository;
import com.example.stin.Users.UserDetails.UserEntity;
import com.example.stin.Users.UserInterface.UserRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;


@AutoConfigureMockMvc(addFilters = false)
@AutoConfigureWebMvc
@WebMvcTest(JsonUserInfoOutput.class)
public class JsonUserOutputTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @MockBean
    private JsonUserInfoOutput jsonUserInfoOutput;


    @InjectMocks
    private JsonUserInfoOutput JsonUserInfoOutput;

//    @Test
//    public void testJson() throws JSONException {
//        Principal principal = Mockito.mock(Principal.class);
//        when(principal.getName()).thenReturn("test@gmail.com");
//        UserEntity user = new UserEntity();
//        user.setName("John");
//        user.setSurname("Doe");
//        user.setEmail("test@gmail.com");
//        AccountEntity account = new AccountEntity();
//        account.setId(1L);
//        account.setAccountNumber(1234567890L);
//        account.setBalanceUSD(1000.0);
//        account.setBalanceEUR(800.0);
//        account.setBalanceCZK(20000.0);
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name", user.getName());
//        jsonObject.put("surname", user.getSurname());
//        jsonObject.put("email", user.getEmail());
//        jsonObject.put("accountNumber", account.getAccountNumber());
//        jsonObject.put("balanceUSD", account.getBalanceUSD());
//        jsonObject.put("balanceEUR", account.getBalanceEUR());
//        jsonObject.put("balanceCZK", account.getBalanceCZK());
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.put(jsonObject);
//        String expected = jsonArray.toString();
//        System.out.println(expected);
//        when(userRepository.findByEmail(anyString())).thenReturn(user);
//        when(accountRepository.findAllById(anyLong())).thenReturn(account);
//        when(transactionRepository.findAllByUserId(anyLong())).thenReturn(new ArrayList<TransactionEntity>());
//
//        MockHttpServletRequestBuilder requestBuilder = get("/json");
//        String actual = jsonUserInfoOutput.json(principal);
//        System.out.println(requestBuilder);
//        JSONAssert.assertEquals(expected, actual, false);
//
//    }
    @Test
    @WithMockUser(username = "admin@gmail.com", password = "admin")
    public void testJson1() throws Exception {
        this.mockMvc.perform(get("/json"))
                .andExpect(status().isOk());
    }


//    @Test
//    @WithMockUser(username = "test@example.com")
//    public void testJson1() throws Exception {
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
//                .andExpect(status().isOk());
//    }

//    @Test
//    @WithMockUser(username = "john.doe@example.com")
//    public void testJsonMethod() throws JSONException {
//        // Mock user
//        UserEntity user = new UserEntity();
//        user.setName("John");
//        user.setSurname("Doe");
//        user.setEmail("john.doe@example.com");
//
//        // Mock account
//        AccountEntity account = new AccountEntity();
//        account.setAccountNumber(1234567890L);
//        account.setBalanceUSD(100.00);
//        account.setBalanceEUR(80.00);
//        account.setBalanceCZK(2000.00);
//
//        // Mock transactions
//        List<TransactionEntity> transactions = new ArrayList<>();
//        TransactionEntity transaction1 = new TransactionEntity();
//        transaction1.setId(1L);
//        transaction1.setAmount(50.00);
//        transaction1.setCurrency("USD");
//        TransactionEntity transaction2 = new TransactionEntity();
//        transaction2.setId(2L);
//        transaction2.setAmount(40.00);
//        transaction2.setCurrency("EUR");
//        transactions.add(transaction1);
//        transactions.add(transaction2);
//
//        // Set up mock repositories and principal
//        when(principal.getName()).thenReturn("john.doe@example.com");
//        when(userRepository.findByEmail("john.doe@example.com")).thenReturn(user);
//        when(accountRepository.findAllById(user.getId())).thenReturn(account);
//        when(transactionRepository.findAllByUserId(account.getAccountNumber())).thenReturn(transactions);
//
////        JsonUserInfoOutput jsonUserInfoOutput = new JsonUserInfoOutput();
//        // Call the controller method
////        String result = jsonUserInfoOutput.json(principal, model);
////        String result = jsonUserInfoOutput.json(principal);
//        // Check the result
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name", user.getName());
//        jsonObject.put("surname", user.getSurname());
//        jsonObject.put("email", user.getEmail());
//        jsonObject.put("accountNumber", account.getAccountNumber());
//        jsonObject.put("balanceUSD", account.getBalanceUSD());
//        jsonObject.put("balanceEUR", account.getBalanceEUR());
//        jsonObject.put("balanceCZK", account.getBalanceCZK());
//        jsonObject.put("transactions", transactions);
//        assertEquals("John", jsonObject.getString("name"));
//        assertEquals("Doe", jsonObject.getString("surname"));
//        assertEquals("john.doe@example.com", jsonObject.getString("email"));
//        assertEquals("1234567890", jsonObject.getString("accountNumber"));
//        assertEquals(100.00, jsonObject.getDouble("balanceUSD"));
//        assertEquals(80.00, jsonObject.getDouble("balanceEUR"));
//        assertEquals(2000.00, jsonObject.getDouble("balanceCZK"));
////        assertEquals(2, jsonObject.getJSONArray("transactions").length());
//    }

    @Test
    void testJsonOutput() {
        JsonUserInfoOutput jsonUserInfoOutput = new JsonUserInfoOutput();
        assertNotNull(jsonUserInfoOutput);
    }

//    @Test
//    void testJsonOutput1() throws JSONException {
//        Principal principal = new Principal() {
//            @Override
//            public String getName() {
//                return "test@example.com";
//            }
//        };
//
//
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
//
//        JsonUserInfoOutput jsonUserInfoOutput = mock(JsonUserInfoOutput.class);
//        when(jsonUserInfoOutput.json(principal)).thenReturn("test");
//        assertNotNull(jsonUserInfoOutput);
//
//        String result = jsonUserInfoOutput.json(principal);
//        assertNotNull(result);
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name", name);
//        jsonObject.put("surname", surname);
//        jsonObject.put("email", email);
//
//        jsonObject.put("accountNumber", accountNumber);
//        jsonObject.put("balanceUSD", balanceUSD);
//        jsonObject.put("balanceEUR", balanceEUR);
//        jsonObject.put("balanceCZK", balanceCZK);
//        jsonObject.put("transactions", transactions);
//
//        assertNotNull(jsonObject);
//
//        assertEquals("John", jsonObject.getString("name"));
//        assertEquals("Doe", jsonObject.getString("surname"));
//
//    }

    @Test
    void testJsonOutput2() {
        Principal principal = mock(Principal.class);
        when(principal.getName()).thenReturn("test");
        when(userRepository.findByEmail("test")).thenReturn(new UserEntity());
        when(accountRepository.findAllById(1L)).thenReturn(new AccountEntity());
        when(transactionRepository.findAllByUserId(1L)).thenReturn(new ArrayList<>());
        JsonUserInfoOutput jsonUserInfoOutput = mock(JsonUserInfoOutput.class);
        when(jsonUserInfoOutput.json(principal)).thenReturn("test");
    }

}
