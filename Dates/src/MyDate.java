public class MyDate {
    private int day;
    private int month;
    private int year;

    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Method that calculates the interval between two dates
    public int getIntervalInMonths(MyDate otherDate) {
        int thisTotalMonths = this.year * 12 + this.month;
        int otherTotalMonths = otherDate.getYear() * 12 + otherDate.getMonth();

        return Math.abs(thisTotalMonths - otherTotalMonths);
    }

    private int countTotalDays(MyDate date) {
        int totalDays = date.getDay(); // Method that counts total days since year 1 for a given date

        // Adds days of all completed months in the current year
        for (int i = 1; i < date.getMonth(); i++) {
            // Iterates through each month prior to the given month and adds the days in each month
            totalDays += daysInMonth(i, date.getYear());
        }

        // Adds the total days of completed years since year 1 till the given year
        totalDays += 365 * date.getYear() + countLeapYears(date.getYear());

        return totalDays;
    }

    private int countLeapYears(int year) {
        if (year <= 2) return 0; // No leap years before year 1 or 2

        // Formula to count leap years
        return year / 4 - year / 100 + year / 400;
    }

    // Determines the number of days in a specific month of a given year
    private int daysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return DAYS_IN_MONTH[month];
    }

    // Checks if a given year is a leap year
    private boolean isLeapYear(int year) {
        // Checks if the year is divisible by 4 and not divisible by 100, or if divisible by 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public MyDate estimateEndDate(int intervalInDays) {
        int totalDays = countTotalDays(this) + intervalInDays;

        int year = 1;
        while (totalDays > 365) {
            if (isLeapYear(year)) {
                if (totalDays > 366) {
                    totalDays -= 366;
                    year++;
                } else {
                    break;
                }
            } else {
                totalDays -= 365;
                year++;
            }
        }

        int month = 1;
        int daysInCurrentMonth;
        while (true) {
            daysInCurrentMonth = daysInMonth(month, year);
            if (totalDays > daysInCurrentMonth) {
                totalDays -= daysInCurrentMonth;
                month++;
            } else {
                break;
            }
        }

        return new MyDate(totalDays, month, year);
    }
}
