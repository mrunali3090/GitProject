package AutomationProject.MavenJava;

import java.io.IOException;
import java.util.ArrayList;

public class ExcelDataTest {

	public static void main(String[] args) throws IOException {
	
		DataDriverExcel d=new DataDriverExcel();
		ArrayList<String> data=d.getData("Pass the row name which has data stored");
		data.get(0);
		data.get(1);
		
	}

}
