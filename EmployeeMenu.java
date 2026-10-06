import java.util.List;
import java.util.Scanner;

public class EmployeeMenu{ //Controller + View
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();
        int choice , choice1;



        do{
        System.out.println("\n---Employee Menu---");
        System.out.println("1. Insert");
        System.out.println("2. Delete");
        System.out.println("3. Update");
        System.out.println("4. Search");
        System.out.println("5. View All");
        System.out.println("6. Exit");
        System.out.println("Enter your choice");
        choice = sc.nextInt();


        try{
        switch (choice) {
            case 1 -> {
                System.out.println("Enter id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter name: ");
                String name = sc.nextLine(); 
                System.out.println("Enter salary: ");
                float salary = sc.nextFloat();

                Employee e = new Employee(id,name,salary);


                int inserted = dao.insertEmployee(e);
                if(inserted > 0)
                    System.out.println("Inserted successfully!"); 
                    
                    
                
            }
            case 2 -> {
                System.out.println("Enter id to be deleted:");
                int id = sc.nextInt();
                int deleted = dao.deleteEmployee(id);
                if(deleted > 0)
                    System.out.println("Deleted Successfully!");
                else
                    System.out.println("ID not found!");
                    

            }
            case 3 -> {
                System.out.println("1.Update Name");
                System.out.println("2.Update Salary");
                System.out.println("Enter your choice:");
                 choice1 = sc.nextInt();

                System.out.println("Enter id to be Updated:");
                int id = sc.nextInt();

                Employee e = dao.getEmployeeById(id);
                if(e == null){
                    System.out.println("Invalid ID!");
                    break;
                }

                if (choice1 == 1) {
                    System.out.println("Enter New Name:");
                    String name = sc.next();
                    e.setName(name);

                    
                }else if(choice1 == 2){
                    System.out.println("Enter New Salary:");
                    float salary = sc.nextFloat();
                    e.setSalary(salary);



                }else{
                    System.out.println("Invalid Choice!");
                    break;
                }

                int Updated = dao.UpdateEmployee(e);
                if(Updated > 0)
                    System.out.println("Updated  Successfully!");
                else
                    System.out.println("Updation failed!");
                    


            }
            case 4 -> {
                    System.out.println("Enter id to be searched: ");
                    int id = sc.nextInt();
                    Employee e = dao.getEmployeeById(id);
                    if(e != null)
                        System.out.println(e);
                    else
                        System.out.println("Employee not found!");
            }
            case 5 -> {

               List<Employee> list = dao.getAllEmployees();
               if (list.isEmpty()) {
                    System.out.println("No Records!");

                
               } else{
                    System.out.println("\n---Employee List ---");
                    for(Employee e : list)
                        System.out.println(e);
               }
            }
            case 6 -> System.out.println("Exiting...");
            default -> System.out.println("Invalid Choice!");
        }
        }catch(DAOException e){
            System.err.println("Any DAO related problem : "+e.getMessage());

        }
        
        catch(Exception e){
            System.err.println("Something wrong happend : "+e.getMessage());
        }


     }while (choice !=6); 


     sc.close();
        
     
    }
}