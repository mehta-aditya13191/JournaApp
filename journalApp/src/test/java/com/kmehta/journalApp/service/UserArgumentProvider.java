package com.kmehta.journalApp.service;

import com.kmehta.journalApp.entity.UserEntity;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class UserArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(UserEntity.builder().userName("Ram").password("djfklsj").build()),
                Arguments.of(UserEntity.builder().userName("adi").password("").build())
        );
    }
}
