import java.util.ArrayList;
import java.util.Arrays;


public class PartTimeStaff extends Staff {

    private double rate;
    private ArrayList<Double> hours = new ArrayList<>();
    
    public PartTimeStaff(String firstname, String lastname, String SSN, String email, double rate)
    {
        super(firstname, lastname, SSN, email);
        this.rate = rate;
    }

    public PartTimeStaff(String firstname, String lastname, double rate)
    {
        super(firstname, lastname);
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void incrementHours(double someHours)
    {
        hours.add(someHours);
    }
    
    public double getHoursWorked()
    {
        double total_hours =0;
        for (double i: hours) total_hours += i;
        return total_hours;
    }
    
    @Override
    public String toString()
    {
        return "Staff:" + super.toString() + " [base salary=" + rate +
                ", hours" + Arrays.toString(hours.toArray()) +"]";
    }
    
    @Override
    public double calcSalary() {
        return rate*getHoursWorked();
    }
    
    public void getDetailedHoursWorkedReport()
    {
        for (int i=0; i<hours.size(); i++)
        {
            System.out.printf("%3d: %f\n", i+1, hours.get(i));
        }
    }
    
    public void removeHoursWorkedEntry(int rowNumber)
    {
        if (rowNumber<1 || rowNumber>hours.size())
        {
            System.err.println("Error: wrong row number");
            return;
        }
        hours.remove(rowNumber-1);
    }
}
