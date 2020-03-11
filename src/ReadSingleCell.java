import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadSingleCell {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("sample_test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet ws = wb.getSheetAt(0);
		String str = String.valueOf(ws.getRow(0).getCell(0));
		String str1 = String.valueOf(ws.getRow(1).getCell(0));
		wb.close();
		System.out.println(str +" "+ str1);
	}

}
