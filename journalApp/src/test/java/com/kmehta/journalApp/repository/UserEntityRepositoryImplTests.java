package com.kmehta.journalApp.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled
public class UserEntityRepositoryImplTests {
    @Autowired
    private UserEntityRepositoryImpl userEntityRepositoryImp;

    //    @Disabled("tested")
    @Test
    public void testSaveNewUser() {
        Assertions.assertNotNull(userEntityRepositoryImp.getUserEntityForSA());
    }

}
