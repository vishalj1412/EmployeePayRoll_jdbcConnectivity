import java.sql.*;
import java.util.scanner;
public class EmploreePayRollServices{
    public static void main(String args[]) {
        try {
            /*
            load the driver class
            */
            System.out.println("Driver Loading...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded!!");

            /*
            create the connection 
            */
            System.out.println("Connecting to DB...");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "root");
            System.out.println("Connected!!!");

            /* 
            create the statement 
            */
            
            Statement stmt = con.createStatement();
            Scanner scan=new Scanner(System.in)
            do{
            System.out.println("1: for insert data 2: show data 3:dalete data 4: sum 5:min 6: max 7:avg ");
            int choice=scan.nextInt()
            switch (choice) {
			case 1:  
			 /*
             Insert data in database
              */
            System.out.println("Insert : Query Executing ...");
            int count = stmt.executeUpdate(
                    "insert into employee_payroll (empId,name,salary,start_date) values(7,'kaivalya',33350,'2008-3-22');");
            System.out.println("Insert : Query Executed!!!\nRows Affected: " + count);
                 break;
            case 2:
            /*
            show the data from table
            */
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee_payroll");
            System.out.println("Select : Query Executed!!!");

            while (rs.next())
                System.out.println("| " + rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " |"+rs.getString(4));
                     break;
            case 3:         
            /*
            delete records from table
            */
            System.out.println("Delete : Query Executing ...");
            count = stmt.executeUpdate("DELETE  FROM employee_payroll where empId=1");
            System.out.println("Delete : Query Executed!!!\nRows Affected: " + count);
              break;
            case 4:
             /*
              do sum opration
              */
             PreparedStatement statement =  con.prepareStatement("select sum(salary) from employee_payroll");
            ResultSet result = statement.executeQuery();
            result.next();
            System.out.println("sum is"+result.getString(1));
                  break;
            case 5:
             /*
              do min opration
              */
             PreparedStatement statement =  con.prepareStatement("select min(salary) from employee_payroll");
            ResultSet result = statement.executeQuery();
            result.next();
            System.out.println("minimum is"+result.getString(1));
                     break;
            case 6:
             /*
               opration
              */
             PreparedStatement statement =  con.prepareStatement("select max(salary) from employee_payroll");
            ResultSet result = statement.executeQuery();
            result.next();
            System.out.println("max is"+result.getString(1));
                   break;
            case 7:
             /*
                get avg
              */
             PreparedStatement statement =  con.prepareStatement("select avg(salary) from employee_payroll");
            ResultSet result = statement.executeQuery();
            result.next();
            System.out.println("avg is"+result.getString(1)); 
              break;
          }
                
             /*
             close the connection object
             */
            System.out.println("Closing connection...");
            con.close();
            System.out.println("Connection Closed!!!");
            ResultSet show = stmt.executeQuery("SELECT * FROM employee_payroll");
            System.out.println("Select : Query Executed!!!");
            
        }

        catch (Exception e) {
            System.out.println(e);
        }

    }
}