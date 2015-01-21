import java.io.IOException;


public class CSVTest {

	public static void main(String[] args) {
		try {
			CSVIO.saveObject("Users", new User ("Haris",22,true));
			CSVIO.saveObject("Users", new User ("Selma",25,true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String [] str={"Selma,","25","true"};
		User newUser= CSVIO.findObject(str);
		System.out.println(newUser.toString());

	}

}
