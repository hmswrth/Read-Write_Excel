import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
public class WriteExcelFile {

	public static void main(String[] args) {
		//Blank workbook
		XSSFWorkbook sample = new XSSFWorkbook();
		
		//Blank sheet
		XSSFSheet sheet = sample.createSheet("Sample Sheet");
		
		//creating data
		Map<String, Object[]> dataset = new TreeMap<String, Object[]>();
		dataset.put("1", new Object[] {"Name","Age","Status"});
		dataset.put("2", new Object[] {"Hemanth","21","wasssaaaap"});
		dataset.put("3", new Object[] {"Alex","234","Dead"});
		dataset.put("4", new Object[] {"Avinash","21","married"});
		dataset.put("5", new Object[] {"pinto","21","unknown"});
		dataset.put("6", new Object[] {"Magic","45","Rich"});
		dataset.put("7", new Object[] {"Kanye","33","Attitude"});
//		dataset.put("8", new Object[] {"Name","Age","Status"});
//		dataset.put("9", new Object[] {"Name","Age","Status"});
//		dataset.put("10", new Object[] {"Name","Age","Status"});
		
		//Iterate over data
		
		Set<String> set = dataset.keySet();
		int rowNo =0;
		for (String key : set) {
			Row row = sheet.createRow(rowNo++);
			Object[] data = dataset.get(key);
			int cellno=0;
			for (Object value : data) {
				Cell cell = row.createCell(cellno++);
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				else if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				
			}
			
		}
		FileOutputStream writefile;
		try {
			writefile = new FileOutputStream("sample_test.xlsx");
			sample.write(writefile);
			writefile.close();
			System.out.println("Sample created successfully!!.");
			sample.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
