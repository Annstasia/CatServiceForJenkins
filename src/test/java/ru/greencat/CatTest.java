package ru.greencat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class CatTest {
    @Test
    public void someTest() {
        int b = 1;
        Assertions.assertEquals("1", String.valueOf(b));
    }
}
