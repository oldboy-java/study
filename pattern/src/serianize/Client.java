package serianize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {

	public static void main(String[] args) {
		
		User user = new User("zzz",18,"178");
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/a.txt"));
			
			oos.writeObject(user);
			
			oos.flush();
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
			
			User user2 =(User) ois.readObject();
			System.out.println(user2.getName()+","+user2.getAge()+","+user2.getHeight());
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
