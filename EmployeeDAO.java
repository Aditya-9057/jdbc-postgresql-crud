import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO implements EmployeeDAOinterface {
    private final String INSERT_SQL = "INSERT INTO employee VALUES(?,?,?)";
    private final String DELETE_SQL = "DELETE FROM employee WHERE id=?";
    private final String UPDATE_SQL = "UPDATE employee SET name=?,salary=? WHERE id=?";
    private final String SELECT_BYID_SQL = "SELECT * FROM employee WHERE id=?";
    private final String SELECT_SQL = "SELECT * FROM employee";


    public int deleteEmployee(int id) throws DAOException{

            int ans = 0;
            try(Connection con = DBconnection.getConnection();
    PreparedStatement psdelete = con.prepareStatement(DELETE_SQL)) {

            psdelete.setInt(1, id);
            ans = psdelete.executeUpdate();
                
            } catch (SQLException sqle) {
                throw new DAOException("Error during deletion : "+sqle.getMessage(),sqle);
            }

            return ans;
    }   

    public int insertEmployee(Employee e ) throws DAOException{

        int ans = 0;
        
        try(Connection con = DBconnection.getConnection();
    PreparedStatement psinsert = con.prepareStatement(INSERT_SQL))
        {
            psinsert.setInt(1,e.getId());
            psinsert.setString(2,e.getName());
            psinsert.setFloat(3,e.getSalary());

            ans = psinsert.executeUpdate();
            
        } catch (SQLException sqle) {
            throw new DAOException("Error during insertion : "+sqle.getMessage(),sqle);
        }

        return ans;

    }


    public Employee getEmployeeById(int id) throws DAOException{
        Employee e = null;
        try(Connection con = DBconnection.getConnection();
    PreparedStatement pssearch = con.prepareStatement(SELECT_BYID_SQL)){

            pssearch.setInt(1, id);
            try(ResultSet rs = pssearch.executeQuery()){
                if (rs.next()) {
                    e = new Employee(rs.getInt(1), rs.getString(2), rs.getFloat(3));
                    
                }

            }
            
        } catch (SQLException sqle) {
            throw new DAOException("Error during searching : "+sqle.getMessage(),sqle);
        }

        return e;
    }

   public int UpdateEmployee(Employee e) throws DAOException{

    int ans = 0;
    try (Connection con = DBconnection.getConnection();
    PreparedStatement psupdate = con.prepareStatement(UPDATE_SQL)) {

        psupdate.setString(1, e.getName());
        psupdate.setFloat(2, e.getSalary());
        psupdate.setInt(3, e.getId());

       ans = psupdate.executeUpdate();
        
    } catch (Exception sqle) {
        throw new DAOException("Error during updating : "+sqle.getMessage(),sqle);
    }

        return ans;

   }

    public List<Employee> getAllEmployees() throws DAOException{
        List<Employee> list = new ArrayList<>();
        try (Connection con = DBconnection.getConnection();
    PreparedStatement psselectall = con.prepareStatement(SELECT_SQL)) {

        try(ResultSet rs = psselectall.executeQuery()){
            while (rs.next()) {
                list.add(new Employee(rs.getInt(1),rs.getString(2),rs.getFloat(3)));
            }
        }

        } catch (Exception sqle) {
            throw new DAOException("Error during fetching : "+sqle.getMessage(),sqle);
        }
        return list;
   }
}
