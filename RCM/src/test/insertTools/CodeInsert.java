package insertTools;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class CodeInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://192.168.1.230:3306/labssm?useUnicode=true&characterEncoding=utf-8";
		String username = "mysql";
		String password ="mysql123";
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = (Connection) DriverManager.getConnection(url,username,password);
		
		Statement stat = (Statement) connection.createStatement();
/*		ResultSet rsResultSet = stat.executeQuery("select * from zd_jb");
		while (rsResultSet.next())
		{System.out.println("id = "+ rsResultSet.getObject("id"));System.out.println("name = "+ rsResultSet.getObject("label"));}
		*/
		
	    
		String abc = FileUtil.getFileByEncoding("C:\\Users\\admin\\Desktop\\codeTest.txt", "utf-8");
		String[] StringArray= abc.split("\n");
		
		/*for (int i = 0; i < StringArray.length; i++) {
			String element = StringArray[i];
			if(element!=null&&!element.equals("")){
				String[] eculme = element.split(" ");
				
				if(!eculme[0].equals("")){
					if(eculme.length>1){
						System.out.println(eculme[0]);
						System.out.println(eculme[1]);
						String sql;
						if(eculme.length<3){
							sql = "insert into qtzd_xx(ID,LABEL) value('"+eculme[0].trim()+"','"+eculme[1].trim()+"')"; 
						}else{
//							sql = "insert into qt_dwyrxsfl(ID,LABEL) value('"+eculme[0].trim()+"','"+eculme[1].trim()+"')"; 
							sql = "insert into qtzd_xx(ID,LABEL,REMARKS) value('"+eculme[0].trim()+"','"+eculme[1].trim()+"','"+eculme[2].trim()+"')";
						}
						 
					    System.out.println(sql);  
					    int statentnum = stat.executeUpdate(sql);  
					    if (statentnum>0) {  
					        System.out.println("insert ok");  
					    }
						
					}
				}
			}
		}*/
		
		
		
//		for(int i=10755;i<10769;i++){
//			
//			String sql="update qtzd_xx set id='"+41650+i+"' where id='"+i+"'";
//			int statentnum = stat.executeUpdate(sql);  
//		    if (statentnum>0) {  
//		        System.out.println("update ok");  
//		    }
//			
//		}
		
		String name="北京";
		String sql="update qtzd_xx set id=concat('41110',id) where label like '%"+name+"%'";
		int statentnum = stat.executeUpdate(sql);  
	    if (statentnum>0) {  
	        System.out.println("update ok");  
	    }
		
		
		
	}
}
