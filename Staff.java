abstract public class Staff {
    protected String firstname;
    protected String lastname;
    private String SSN;
    private String email;
    
    public Staff(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public Staff(String firstname, String lastname, String SSN, String email)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.SSN = SSN;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
    
    @Override
    public String toString()
    {
        return lastname + " " + firstname;
    }
    
    abstract double calcSalary();
}
