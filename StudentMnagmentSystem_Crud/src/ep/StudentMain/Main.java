package ep.StudentMain;

import java.sql.SQLException;
import java.util.Scanner;

import ep.PreparedStatments.DAO;
import ep.StudentBean.StudentBean;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		DAO crud=new DAO();
		Scanner sc=new Scanner(System.in);
		int choice,regno;
		String name;
		
		while(true)
		{
			System.out.println("1.Insert the Data\n 2.Delete the Data \n 3. Update THe Data \n 4. Display the Data\n 5.Enter 5 to exit");
			System.out.println("Select your choice from the above given choices : ");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:StudentBean student=new StudentBean();
					student.setRegno(5);
					student.setName("nani");
					student.setEmail("nani@gmail.com");
					int i=crud.studentInsertion(student);
					if (i>0)
					{
						System.out.println(i+" Row Inserted Successfully");
					}
					else
					{
						System.out.println("not Inserted Successfully");
					}
					break;
			case 2:System.out.println("Enter regno for the row to be deleted");
					regno=sc.nextInt();
					int j=crud.studentDelete(regno);
					if (j>0)
					System.out.println(j+"row Deleted REGNO"+regno);
					else
						System.out.println("row is not found ");
					break;
			case 3:System.out.println("Enter regno for name to be updated");
					regno=sc.nextInt();
					System.out.println("Enter name for the name to be updated");
					name=sc.next();
					int k=crud.studentUpdate(regno,name);
					if (k>0)
						System.out.println(k+"row updated ");
						else
							System.out.println("row is not found ");
					System.out.println("Updated...");
					break;
			case 4 :crud.studentDisplay();
					break;
			case 5:System.exit(0);
			}
		}
		
		

	}

}
