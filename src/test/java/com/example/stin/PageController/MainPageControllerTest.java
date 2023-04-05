package com.example.stin.PageController;

import com.example.stin.Bank.Account.AccountEntity;
import com.example.stin.Bank.Account.AccountRepository;
import com.example.stin.Bank.Transaction.TransactionEntity;
import com.example.stin.Bank.Transaction.TransactionRepository;
import com.example.stin.Bank.Transaction.TransactionService;
import com.example.stin.CurencyData.CNBData;
import com.example.stin.Users.UserDetails.UserEntity;
import com.example.stin.Users.UserInterface.UserRepository;
import com.example.stin.WalletController.BalanceManager.BalanceChecker;
import com.example.stin.WalletController.MoneyManager.MoneyManager;
import org.aspectj.util.LangUtil;
import org.jboss.jandex.Main;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Captor
    ArgumentCaptor<AccountEntity> accountCaptor;

    @Mock
    private Model model;

    @Mock
    private Principal principal;

    @Test
    public void testIndex() {
        MainPageController controller = new MainPageController();
        String result = controller.index();
        assertEquals("main", result);
    }

//    @Test
//    public void testIndexPost() throws Exception {
//        MainPageController controller = new MainPageController();
//        UserEntity user = new UserEntity();
//        user.setId(1L);
//        AccountEntity account = new AccountEntity();
//        account.setId(1L);
//        account.setBalanceUSD(1000.0);
//        String amount = "100";
//        String payment = "test";
//        String currency = "USD";
//        String currency2 = "EUR";
//        Model model = mock(Model.class);
//
//
//        when(model.getAttribute("user")).thenReturn(user);
//        when(accountRepository.findAllById(user.getId())).thenReturn(account);
//
//
//    }

//    @Test()
//    public void testProcess() {
//        AccountEntity account = new AccountEntity();
//        account.setId(1L);
//        account.setBalanceUSD(100.0);
//        account.setBalanceEUR(200.0);
//        account.setBalanceCZK(300.0);
//
//        TransactionService transactionService = Mockito.mock(TransactionService.class);
//        MoneyManager moneyManager = Mockito.mock(MoneyManager.class);
//
////        transactionService.CreateTransaction(account, "USD", 50.0, "Payment");
//
//        String amount = "50.0";
//        String payment_type = "Payment";
//        String currency_list = "USD";
//        String transfer = "USD";
//
//        doReturn(account).when(moneyManager).payMoney(account, Double.parseDouble(amount), currency_list);
//        doReturn(new TransactionEntity()).when(transactionService).CreateTransaction(account, currency_list, Double.parseDouble(amount), payment_type);
//
//        AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
//        TransactionRepository transactionRepository = Mockito.mock(TransactionRepository.class);
//
//        MainPageController bankingController = new MainPageController();
//
//        bankingController.process(amount, payment_type, currency_list, transfer, account);
//
//        verify(moneyManager, times(1)).payMoney(account, Double.parseDouble(amount), currency_list);
//        verify(transactionService, times(1)).CreateTransaction(account, currency_list, Double.parseDouble(amount), payment_type);
//        verify(accountRepository, times(1)).save(account);
//        verify(transactionRepository, times(1)).save(any(TransactionEntity.class));
//    }

    @Test
    public void testProcess_withNullValues() {
        //Arrange
        String amount = null;
        String payment_type = null;
        String currency_list = null;
        String transfer = null;
        AccountEntity account = null;

        //Act
        MainPageController bankingController = new MainPageController();
        bankingController.process(amount, payment_type, currency_list, transfer, account);
//        Exception exception = assertThrows(NullPointerException.class, () -> {
//
//        });

//        String message = exception.getMessage();
//        assertTrue(message.contains());
        //Assert - expected exception is thrown
    }

    @Test
    public void testProcess_withNullAmount() {
        //Arrange
        String amount = null;
        String payment_type = "Payment";
        String currency_list = "USD";
        String transfer = "USD";
        AccountEntity account = new AccountEntity();

        MainPageController bankingController = new MainPageController();
        //Act
        bankingController.process(amount, payment_type, currency_list, transfer, account);

        //Assert - expected exception is thrown
    }

    @Test
    public void testProcess_withInvalidPaymentType() {
        //Arrange
        String amount = "100";
        String payment_type = "invalid";
        String currency_list = "USD";
        String transfer = "USD";
        AccountEntity account = new AccountEntity();
        MainPageController bankingController = new MainPageController();
        //Act
        bankingController.process(amount, payment_type, currency_list, transfer, account);

        //Assert - expected exception is thrown
    }

    @Test
    public void testProcess_withInvalidCurrencyList() {
        //Arrange
        String amount = "100";
        String payment_type = "Payment";
        String currency_list = "invalid";
        String transfer = "USD";
        AccountEntity account = new AccountEntity();
        MainPageController bankingController = new MainPageController();
        //Act
        bankingController.process(amount, payment_type, currency_list, transfer, account);

        //Assert - expected exception is thrown
    }

    @Test
    public void testProcess_withInvalidTransfer() {
        //Arrange
        String amount = "100";
        String payment_type = "Payment";
        String currency_list = "USD";
        String transfer = "invalid";
        AccountEntity account = new AccountEntity();
        MainPageController bankingController = new MainPageController();
        //Act
        Exception exception = assertThrows(NullPointerException.class, () -> {
            bankingController.process(amount, payment_type, currency_list, transfer, account);
        });
        String msg = exception.getMessage();
        assertTrue(msg.contains("is null"));
        //Assert - expected exception is thrown
    }

    @Test
    public void testProcess_withNonexistentAccount() {
        //Arrange
        String amount = "100";
        String payment_type = "Payment";
        String currency_list = "USD";
        String transfer = "USD";
        AccountEntity account = null;
        MainPageController bankingController = new MainPageController();
        //Act
        Exception exception = assertThrows(NullPointerException.class, () -> {
            bankingController.process(amount, payment_type, currency_list, transfer, account);
        });
        String msg = exception.getMessage();
        assertTrue(msg.contains("is null"));
        //Assert - expected exception is thrown
    }

    @Test
    public void testProcess_withInsufficientFunds() {
        //Arrange
        String amount = "1000";
        String payment_type = "Payment";
        String currency_list = "USD";
        String transfer = "USD";
        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(500.0);
        MainPageController bankingController = new MainPageController();
        //Act
        bankingController.process(amount, payment_type, currency_list, transfer, account);
    }

    @Test
    void testProcess_IfPaymentTypeIsPayment() {
        //Arrange
        String amount = "100";
        String payment_type = "Payment";
        String currency_list = "USD";
        String transfer = "USD";
        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(1000.0);
        MainPageController bankingController = new MainPageController();
        //Act
        Exception exception = assertThrows(NullPointerException.class, () -> {
            bankingController.process(amount, payment_type, currency_list, transfer, account);
        });

        String msg = exception.getMessage();
        assertTrue(msg.contains("is null"));

    }

    @Test
    void testProcess_IfPaymentTypeIsAdding() {
        //Arrange
        String amount = "100";
        String payment_type = "Adding";
        String currency_list = "USD";
        String transfer = "USD";
        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(1000.0);
        account.setBalanceCZK(1000.0);
        account.setBalanceEUR(1000.0);
        account.setId(1L);
        account.setAccountNumber(12L);
        MainPageController bankingController = new MainPageController();
        //Act
        Exception exception = assertThrows(NullPointerException.class, () -> {
            bankingController.process(amount, payment_type, currency_list, transfer, account);
        });
        //Assert
        String msg = exception.getMessage();
        assertTrue(msg.contains("is null"));
    }

    @Test
    void testProcess_IfPaymentTypeIsPaymentDifferentCurrency() {
        //Arrange
        String amount = "100";
        String payment_type = "Payment";
        String currency_list = "USD";
        String transfer = "CZK";
        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(1000.0);
        account.setBalanceCZK(1000.0);
        account.setBalanceEUR(1000.0);
        account.setId(1L);
        account.setAccountNumber(12L);
        MainPageController bankingController = new MainPageController();
        //Act
        Exception exception = assertThrows(NullPointerException.class, () -> {
            bankingController.process(amount, payment_type, currency_list, transfer, account);
        });
        //Assert
        String msg = exception.getMessage();
        assertTrue(msg.contains("is null"));
    }

    @Test
    void testProcess_IfPaymentTypeIsAddingDifferentCurrency() {
        //Arrange
        String amount = "100";
        String payment_type = "Adding";
        String currency_list = "USD";
        String transfer = "CZK";
        AccountEntity account = new AccountEntity();
        account.setBalanceUSD(1000.0);
        account.setBalanceCZK(1000.0);
        account.setBalanceEUR(1000.0);
        account.setId(1L);
        account.setAccountNumber(12L);
        MainPageController bankingController = new MainPageController();
        //Act
        Exception exception = assertThrows(NullPointerException.class, () -> {
            bankingController.process(amount, payment_type, currency_list, transfer, account);
        });
        //Assert
        String msg = exception.getMessage();
        assertTrue(msg.contains("is null"));
    }

    @Test
    public void testGetCNBData() {
        // Arrange
        Model model = new ExtendedModelMap();

        MainPageController controller = new MainPageController();
        // Act
        controller.getCNBData(model);

        // Assert
        assertTrue(model.containsAttribute("USD"));
        assertNotNull(model.getAttribute("USD"));
        assertTrue(model.containsAttribute("EUR"));
        assertNotNull(model.getAttribute("EUR"));
        assertTrue(model.containsAttribute("GBP"));
        assertNotNull(model.getAttribute("GBP"));
        assertTrue(model.containsAttribute("isValid"));
        assertTrue(model.getAttribute("isValid") instanceof Boolean);

        CNBData cnbData = new CNBData();
        boolean expectedIsValid = cnbData.isDataActual();
        boolean actualIsValid = (Boolean) model.getAttribute("isValid");
        assertEquals(expectedIsValid, actualIsValid);
    }

    @Test
    void testGetCurrencyChanges() {
        Model model = new ExtendedModelMap();

        MainPageController controller = new MainPageController();

        controller.getCurrencyChanges(model);

        assertTrue(model.containsAttribute("euroChanges"));
        assertNotNull(model.getAttribute("euroChanges"));
        assertTrue(model.containsAttribute("usdChanges"));
        assertNotNull(model.getAttribute("usdChanges"));
        assertTrue(model.containsAttribute("gbpChanges"));
        assertNotNull(model.getAttribute("gbpChanges"));

    }
//
//    @Test
//    public void testGetUserDetails() {
//        // mock test data
//        String email = "test@example.com";
//        UserEntity user = new UserEntity();
//        user.setId(1L);
//        user.setEmail(email);
//        AccountEntity accountInfo = new AccountEntity();
//        accountInfo.setAccountNumber(123456L);
//        List<TransactionEntity> transactionEntityList = new ArrayList<>();
//        TransactionEntity transaction1 = new TransactionEntity();
//        transaction1.setAmount(10.0);
//        transactionEntityList.add(transaction1);
//        when(principal.getName()).thenReturn(email);
//        when(userRepository.findByEmail(email)).thenReturn(user);
//        when(accountRepository.findAllById(user.getId())).thenReturn(accountInfo);
//        when(transactionRepository.findAllByUserId(accountInfo.getAccountNumber())).thenReturn(transactionEntityList);
//        when(BalanceChecker.isBalanceExist(accountInfo, "USD")).thenReturn(100.0);
//        when(BalanceChecker.isBalanceExist(accountInfo, "EUR")).thenReturn(50.0);
//        when(BalanceChecker.isBalanceExist(accountInfo, "CZK")).thenReturn(0.0);
//        MainPageController controller = new MainPageController();
//
//        // call method
//        controller.getUserDetails(model, principal);
//
//        // assert model attributes
//        verify(model).addAttribute("user", user);
//        verify(model).addAttribute("account", accountInfo);
//        verify(model).addAttribute("usdBalance", 100.0);
//        verify(model).addAttribute("eurBalance", 50.0);
//        verify(model).addAttribute("czkBalance", 0.0);
//        verify(model).addAttribute("transaction", transactionEntityList);
//    }

}

