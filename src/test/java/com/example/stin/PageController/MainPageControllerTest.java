package com.example.stin.PageController;

import com.example.stin.Bank.Account.AccountEntity;
import com.example.stin.Bank.Account.AccountRepository;
import com.example.stin.Bank.Transaction.TransactionEntity;
import com.example.stin.Bank.Transaction.TransactionRepository;
import com.example.stin.Users.UserDetails.UserEntity;
import com.example.stin.Users.UserInterface.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@AutoConfigureMockMvc(addFilters = false)
@AutoConfigureWebMvc
@WebMvcTest(MainPageController.class)
class MainPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private TransactionRepository transactionRepository;

//    @Test
//    void testIndex() throws Exception {
//        Principal principal = mock(Principal.class);
//        when(principal.getName()).thenReturn("test");
//
//        // Mock the user repository to return a user with a fixed username
//        UserEntity user = new UserEntity();
//        user.setId(1L);
//        AccountEntity account = new AccountEntity(1L, 1000.0, 100.0, 100.0);
//        when(accountRepository.findAllById(1L)).thenReturn(account);
//
//
//        // Verify that GET request to "/" returns "main" view
//        mockMvc.perform(MockMvcRequestBuilders.get("/").principal(principal))
//                .andExpect(status().isOk())
//                .andExpect(view().name("main"));
//    }

//    @Test
//    void testGetUserDetails() throws Exception {
//        // Set up mock objects
//        Principal mockPrincipal = mock(Principal.class);
//        when(mockPrincipal.getName()).thenReturn("testuser@example.com");
//
//        UserEntity mockUser = new UserEntity();
//        mockUser.setId(1L);
//        mockUser.setEmail("testuser@example.com");
//
//        AccountEntity mockAccount = new AccountEntity();
//        mockAccount.setId(1L);
//        mockAccount.setAccountNumber(1L);
//        mockAccount.setBalanceCZK(1000.0);
//        mockAccount.setBalanceEUR(100.0);
//        mockAccount.setBalanceUSD(100.0);
//
//        List<TransactionEntity> mockTransactions = Arrays.asList(
//                new TransactionEntity(),
//                new TransactionEntity()
//        );
//
//        MainPageController controller = new MainPageController();
//
//
//        // Set up model and dependencies for method call
//        Model mockModel = mock(Model.class);
//        when(userRepository.findByEmail("testuser@example.com")).thenReturn(mockUser);
//        when(accountRepository.findAllById(1L)).thenReturn(mockAccount);
//        when(transactionRepository.findAllByUserId(1L)).thenReturn(mockTransactions);
//
//        // Call method and verify results
//        controller.getUserDetails(mockModel, mockPrincipal);
//
//        verify(mockModel).addAttribute("user", mockUser);
//        verify(mockModel).addAttribute("account", mockAccount);
//        verify(mockModel).addAttribute("usdBalance", true);
//        verify(mockModel).addAttribute("eurBalance", false);
//        verify(mockModel).addAttribute("czkBalance", false);
//        verify(mockModel).addAttribute("transaction", mockTransactions);
//    }


}

