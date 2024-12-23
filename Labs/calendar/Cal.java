package se.liu.denjo163.calendar;

import java.util.ArrayList;
import java.util.List;

public class Cal
{
    private List<Appointment> appointments;

    public Cal(final List<Appointment> appointments) {
        this.appointments = new ArrayList<>();
    }

    public void show() {
        for (Appointment subject : appointments) {
            System.out.println(subject);
        }
    }
    public void book(int year, String month, int day,
                     int startHour, int startMinute, int endHour,
                     int endMinute, String subject) {
        if (year <= 1970) {
            throw new IllegalArgumentException("year out of range");
        }
        if (startHour < 0 || startHour > 23 || endHour < 0 || endHour > 23) {
            throw new IllegalArgumentException("hour out of range");
        }
        if (startMinute < 0 || startMinute > 59 || endMinute < 0 || endMinute > 59) {
            throw new IllegalArgumentException("minute out of range");
        }
        if (Month.MONTH_NAME_TO_NUMBER.getOrDefault(month, -1) == -1) {
            throw new IllegalArgumentException("not a month");
        }
        if (Month.MONTH_NAME_TO_LENGHT.get(month) < day) {
            throw new IllegalArgumentException("invalid amount of days");
        }
        SimpleDate date = new SimpleDate(year, month, day);
        TimePoint start = new TimePoint(startHour, startMinute);
        TimePoint end = new TimePoint(endHour, endMinute);
        TimeSpan timeSpan = new TimeSpan(start, end);
        Appointment appointment = new Appointment(subject, date, timeSpan);
        appointments.add(appointment);
    }

    public static void main(String[] args) {
        Cal calendar = new Cal(new ArrayList<Appointment>());

        calendar.book(2022, "january", 1, 9, 45, 10, 10, "Something");
        calendar.book(2021, "february", 5, 14, 30, 16, 30, "Something");
        calendar.book(2022, "june", 30, 10, 10, 12, 0, "Something");
        calendar.book(2002, "march", 20, 8, 30, 9, 20, "Something");
        calendar.book(2022, "december", 16, 16, 0, 18, 35, "Something");

        calendar.show();
    }

}

