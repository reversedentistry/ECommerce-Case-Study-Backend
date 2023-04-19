package com.revature.ecommerce.repository;

import com.revature.ecommerce.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepoTest;
    User user;

    @BeforeEach
    void setUp() {
        user = new User(
                1,
                "testuser",
                "testpassword"
        );
        userRepoTest.save(user);
    }

    @AfterEach
    void tearDown() {
        user = null;
        userRepoTest.deleteAll();
    }

    // Successful test
    @Test
    void checksIfCorrectlyFindingByUsername() {
        String testUsername = "testuser";
        User expected = userRepoTest.findByUsername(testUsername);

        assertThat(expected).isEqualTo(user);
    }

    // Unsuccessful test
    @Test
    void checksForNonExistentUsername() {
        String testUsername = "notestuser";
        User expected = userRepoTest.findByUsername(testUsername);

        assertThat(expected).isEqualTo(null);
    }
}