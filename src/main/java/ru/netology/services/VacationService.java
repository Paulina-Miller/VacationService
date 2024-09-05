package ru.netology.services;

public class VacationService {
    public int calculateVacation(int income, int expense, int threshold) {
        int months = 12;  // количество месяцев в году
        int savings = 0;  // изначально у нас нет денег
        int vacationMonths = 0;  // счетчик месяцев отдыха

        for (int month = 1; month <= months; month++) {
            if (savings >= threshold) {
                // Если на счету достаточно денег, решаем отдохнуть
                vacationMonths++;
                savings -= expense; // уменьшаем на обязательные расходы
                savings /= 3; // уменьшаем остаток накоплений в три раза
            } else {
                // Иначе работаем
                savings += income; // увеличиваем деньги на доход
                savings -= expense; // уменьшаем на обязательные расходы
            }
        }

        return vacationMonths; // возвращаем количество месяцев отдыха
    }
}
