package se.liu.denjo163.calendar;

public class Appointment
{
    private String subject;
    private SimpleDate date;
    private TimeSpan timespan;

    public String getSubject() {
	return subject;
    }
    public SimpleDate getDate() {
	return date;
    }
    public TimeSpan getTimespan() {
	return timespan;
    }

    public Appointment(final String subject, final SimpleDate date, final TimeSpan timespan) {
	this.subject = subject;
	this.date = date;
	this.timespan = timespan;
    }

    @Override public String toString() {
	return "Appointment: " + subject + ", date: " + date + ", time: " + timespan;
    }
}
