import java.util.HashMap;


public class Tester {

    public static void main(String[] args) {
        PartTimeStaff a = new PartTimeStaff("Maira", "Kotsovoulou", 20);
        PartTimeStaff b = new PartTimeStaff("Evgenia", "Vagianou", 22);
        a.incrementHours(3);
        a.incrementHours(2);
        b.incrementHours(6);
        b.incrementHours(1);
        b.incrementHours(2);
        
        System.out.println(a.getEmail());
        System.out.println(a.getSSN());

        System.out.println(b);
        System.out.println(b.getEmail());
        System.out.println(b.getSSN());
        
        HashMap<String,Staff> employees = new HashMap<>();
        
        employees.put(a.getSSN(), a);
        employees.put(b.getSSN(), b);
        
        a.getDetailedHoursWorkedReport();
        
        b.removeHoursWorkedEntry(1);
    }
    
}
