package ru.greencat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogicTest {
    private final CatLogic logic = new CatLogic();
    @Test
    public void testLogic() {
        Assertions.assertEquals(6, logic.logic(0));
        Assertions.assertEquals(6, logic.logic(1));
        Assertions.assertEquals(3, logic.logic(6));
    }
}
