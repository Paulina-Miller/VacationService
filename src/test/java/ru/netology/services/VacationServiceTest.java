package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class VacationServiceTest {

    @Test
    public void testCalculateVacations1() {
        VacationService service = new VacationService();

        // Тест1: Проверка с примерными значениями
        int income = 100;
        int expense = 50;
        int threshold = 100;
        int expectedVacations = 4; // ожидаемое количество месяцев отдыха

        int actualVacations = service.calculateVacation(income, expense, threshold);

        Assertions.assertEquals(expectedVacations, actualVacations);
    }

    @Test
    public void testCalculateVacations2() {
        VacationService service = new VacationService();
        // Параметры, которые гарантируют только работу
        int income = 5;
        int expense = 200;
        int threshold = 100;
        int expectedVacations = 0; // ожидаемое количество месяцев отдыха

        int actualVacations = service.calculateVacation(income, expense, threshold);

        Assertions.assertEquals(expectedVacations, actualVacations);
    }

    @Test
    public void testCalculateVacations3() {
        VacationService service = new VacationService();
        // Параметры, которые гарантируют только отдых
        int income = 10;
        int expense = 0;
        int threshold = 0;
        int expectedVacations = 12; // ожидаемое количество месяцев отдыха

        int actualVacations = service.calculateVacation(income, expense, threshold);

        Assertions.assertEquals(expectedVacations, actualVacations);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/vacation.csv")
    public void testCalculateVacation(int income, int expense, int threshold, int expectedVacations) {
        VacationService service = new VacationService();
        int actualVacations = service.calculateVacation(income, expense, threshold);
        Assertions.assertEquals(expectedVacations, actualVacations);
    }
}
