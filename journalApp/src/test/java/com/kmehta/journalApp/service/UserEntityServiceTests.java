package com.kmehta.journalApp.service;

import com.kmehta.journalApp.entity.UserEntity;
import com.kmehta.journalApp.repository.UserEntityRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Disabled
public class UserEntityServiceTests {
    @Autowired
    private UserEntityRepository userRepository;

    @Autowired
    private UserEntityService userService;


    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    public void testSaveNewUser(UserEntity user) {
        assertTrue(userService.saveNewUser(user));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a + b);
    }
}
