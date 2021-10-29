
public class HourlyEmployee extends Employee {

    private int hoursWorked;
    private int payRate;
    private int earnings;

    int getHoursWorked() {
        return hoursWorked;
    }

    int getPayRate() {
        return payRate;
    }

    int getEarnings() {
        return earnings;
    }

    HourlyEmployee(Name name, Address address, Date date, int id, int hoursWorked, int payRate) {
        super(name, address, date, id);
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
        this.earnings = calculateEarnings(hoursWorked, payRate);
    }

    int calculateEarnings(int hoursWorked, int payRate) {
        if (hoursWorked <= 40) {
            return payRate * hoursWorked;
        }

        int normalEarnings = 40 * payRate;

        int overTimeHours = hoursWorked - 40;

        double overTimeEarnings = payRate * 1.5 * overTimeHours;

        return (int) (normalEarnings + overTimeEarnings);
    }
}
