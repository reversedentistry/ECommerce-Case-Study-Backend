package com.revature.ecommerce.service;

import com.revature.ecommerce.model.User;
import com.revature.ecommerce.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class UserServiceTest {
    @Mock
    private UserRepository userRepoMock;
    @InjectMocks
    private UserService userServiceTest;
    AutoCloseable autoCloseable;
    User user;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        user = new User(
                1,
                "testuser",
                "testpassword"
        );
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void checkIfCorrectlyCreatingNewUser() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepoMock.save(user)).thenReturn(user);
        assertThat(userServiceTest.createNewUser(user)).isEqualTo(user);
    }

    @Test
    void userLogin() {
        mock(User.class);
        mock(UserRepository.class);

        String testUsername = "testuser";

        when(userRepoMock.findByUsername(testUsername)).thenReturn(user);
        assertThat(userServiceTest.userLogin(user)).isEqualTo(true);

    }
}