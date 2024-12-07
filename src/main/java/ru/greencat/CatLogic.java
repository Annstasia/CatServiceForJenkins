package ru.greencat;

import org.springframework.stereotype.Service;

@Service
public class CatLogic {
    public int logic(int count) {
        if (count == 0) {
            count = 1;
        }
        if (count % 2 == 0) {
            return count / 2;
        } else {
            return count * 6;
        }
    }
}
