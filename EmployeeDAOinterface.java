import java.util.List;

public interface  EmployeeDAOinterface  {
    int insertEmployee(Employee e) throws DAOException;
    int deleteEmployee(int id) throws DAOException;
    int UpdateEmployee(Employee e) throws DAOException;
    Employee getEmployeeById(int id) throws DAOException;
    List<Employee> getAllEmployees() throws DAOException;

}
