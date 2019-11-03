package ru.itvitality.sbrf.cu.rj.atm.atm;

import java.io.IOException;

/**
 * Команды для инкасаторов
 */
public interface ATMService {
    Integer getBalance();
    void saveToFile(String fileName) throws IOException;
}
