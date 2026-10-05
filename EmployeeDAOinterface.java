import java.util.List;

public interface  EmployeeDAOinterface {
    int insertEmployee(Employee e);
    int deleteEmployee(int id);
    int UpdateEmployee(Employee e);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();

}
