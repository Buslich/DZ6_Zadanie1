package ru.netology.stats;

public class StatsService {
    // Расчет всех продаж
    public long sumSales(long[] sales) {
        long sum = 0;
        for (long sale : sales) {
            sum += sale;
        }
        return sum;
    }

    // Расчет средней суммы продаж в месяц
    public long avgSales(long[] sales) {
        return sumSales(sales) / sales.length;
    }

    // Номер месяца с минимальными продажами
    public int minSales(long[] sales) {
        int minMonth = 0;

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) {
                minMonth = i;
            }
        }

        return minMonth + 1;
    }

    // Номер месяца с максимальными продажами
    public int maxSales(long[] sales) {
        int maxMonth = 0; // номер месяца с максимальными продажами среди просмотренных ранее

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxMonth]) { // значит, в рассматриваемом i-м месяце продаж больше
                maxMonth = i; // запомним его как максимальный
            }
        }

        return maxMonth + 1; // месяца нумеруются с 1, а индексы массива с 0, нужно сдвинуть ответ на 1
    }
    // Месяцы с продажами ниже среднего
    public int lessThanAvgSales(long[] sales) {
        int count = 0;
        long avg = avgSales(sales);
        for (long sale : sales) {
            if (sale < avg) {
                count++;
            }
        }
        return count;
    }
    // Месяцы с продажами выше среднего
    public int moreThanAvgSales(long[] sales) {
        int count = 0;
        long avg = avgSales(sales);
        for (long sale : sales) {
            if (sale > avg) {
                count++;
            }
        }
        return count;
    }
}
