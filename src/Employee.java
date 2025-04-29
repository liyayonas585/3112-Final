public class Employee extends User{ 
    private int employeeID; // Unique ID for each employee
    
    public Employee(String name, String userID, String job, int employeeID) {
        super(name, userID, "Employee");
        this.employeeID = employeeID;
    }

}
