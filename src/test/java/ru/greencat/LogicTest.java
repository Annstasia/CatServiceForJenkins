package ru.greencat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogicTest {
    private final CatLogic logic = new CatLogic();
    @Test
    public void testLogic() {
        Assertions.assertEquals(0, logic.logic(0));
        Assertions.assertEquals(6, logic.logic(1));
    }
}
