package AutomationProject.MavenJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriverExcel {
	
	public ArrayList<String> getData(String testcasename) throws IOException
	{
	ArrayList<String> list=new ArrayList<>();
		
		FileInputStream file=new FileInputStream("Path of the excel");// this is use to read the excel file
		//Get the access of an excel first
		
		//Create an object of XSSFWorkbook to perform operations on the excel file
		
		XSSFWorkbook workbook=new XSSFWorkbook(file); //The fileinputstream object will give the XSS class acess to perform operations
		
		//Get the total number of sheets in an excel and store its count into a variable
		//The data we want to access can lie into any sheet inside an excel
		
		int sheets= workbook.getNumberOfSheets(); // count of sheets
		
		//traverse through the sheets until the desired sheet is found
		
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("SheetName")) // if the sheet at ith index is the sheet you want
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				
			Iterator<Row>rows=sheet.iterator(); // This iterator will iterate through the row  to find the heading of the row where the data is stored
			
			Row firstrow=rows.next();// entire row will be stored into this variable firstrow
			
			Iterator<Cell> ce=firstrow.cellIterator();
			
			//Now to get the exact match of the cell 
			int k=0; //counter , which will increment until the cell in a row is found
			int column=0;
			
			while(ce.hasNext())// if next cell is present in a Row
			{
				Cell value=ce.next(); // this will move the cell
				if(value.getStringCellValue().equalsIgnoreCase("Name of the cell"))// now the cell is found in a row
				{
					column=k; // index of the column 
				}
				k++;	
			}
			System.out.println(column);// prints the index of the column
			
			
			// Now check the rows under the column found above to find the desired row
			
			while(rows.hasNext())
			{
				Row r=rows.next(); //stores the next cell in the column
				r.getCell(column).getStringCellValue().equalsIgnoreCase("row name"); // get the string value of the cell in the column which is the row
			
			//r is the desired row
				//pull the data of that row and feed to the test
				
				Iterator<Cell> it= r.cellIterator(); //it is the cell iterator to get the data from the desired row
				
				while(it.hasNext())
				
				{
					//if the cell value is int instead of string
					Cell c=it.next();
					if(c.getCellTypeEnum()==CellType.STRING) // if the cell has string value
					{
					list.add(it.next().getStringCellValue()); //data is added to an arrayList
					}
					else
					{
						list.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							
					}
					
				}
				
				
			}
	
			
		}
		}
		return list;

	}


}
