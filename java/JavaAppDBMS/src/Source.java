import java.sql.*;


public class Source 
{
	static final String driver="com.mysql.jdbc.Driver";
    static final String dbConString="jdbc:mysql://localhost/firstschema";
    static final String uname="root";
    static final String password="root";
    
    public static void main1(String[] args) 
    {
        try 
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(dbConString,uname,password);
            System.out.println("SQL Connection successful !!!");
            Statement st = conn.createStatement();
            int rowsInserted = st.executeUpdate("insert into employee values (104,'Purushottam singh',19000)"); 
            if(rowsInserted>0)
                System.out.println("Insertion Successful !!!");
        } 
        catch (SQLException ex) 
        {
            System.out.println("SQL Exception: " +ex.getMessage());
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println("JDBC Driver not found: " +ex.getMessage());
        }
    }
    
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName(driver);
			System.out.println("Class found !!!");
			Connection conn = DriverManager.getConnection(dbConString,uname,password);
			System.out.println("SQL Connection Successful ...");
			Statement st=conn.createStatement();
//			ResultSet rs=st.executeQuery("select * from employee");
			ResultSet rs = st.executeQuery("Select * from employee where salary >15000");
			if(rs.next())
            {
				System.out.println("id="+rs.getInt(1));
                System.out.println(rs.getString("name"));
                System.out.println("Name =" + rs.getString(2));
                System.out.println("Salary=" + rs.getDouble(3));
            }
			/* while(rs.next())
	            {
	                System.out.println("EmpId= " +rs.getInt(1) + " EmpName= " +rs.getString(2)
	                +" EmpSalary= " +rs.getDouble(3));
	            }*/
			
		} 
		catch (ClassNotFoundException e) 
		{
			 System.out.println("JDBC Driver not found: " +e.getMessage());
		} 
		catch (SQLException e) 
		{
			System.out.println("SQL Exception: " +e.getMessage());
		}
	}

}
