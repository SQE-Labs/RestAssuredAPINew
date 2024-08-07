package api.utilities;
import org.testng.annotations.*;
public class DataProviders {

    
	
	@DataProvider(name="AllData")
	public String [][] AllProvider(){
		
		
		String filname = System.getProperty("user.dir") + "//TestData//TestData.xlsx";
		
        int ttlRowCnt = ReadExcelFile.getRowCount(filname, "Sheet1");
        int ttlColCnt = ReadExcelFile.getcolcount(filname, "Sheet1");
		
        String userData[][] = new String[ttlRowCnt-1][ttlColCnt];
        
        
        for(int rowNo = 1 ; rowNo< ttlRowCnt;rowNo ++) {
        	
        	for(int colNo = 0 ; colNo < ttlColCnt; colNo++) {
        		
        		userData[rowNo -1][colNo] = ReadExcelFile.getCellValue(filname, "Sheet1", rowNo, colNo);
        	}
        }
        
        return userData;
        
				
	}
	
	
	
	
	
	@DataProvider(name="UserNamesData")
	public String [] UserNameDataProvider(){
		
		
		String filname = System.getProperty("user.dir") + "//TestData//TestData.xlsx";
		
        int ttlRowCnt = ReadExcelFile.getRowCount(filname, "Sheet1");
        //int ttlColCnt = ReadExcelFile.getcolcount(filname, "Sheet1");
		
        String userNameData[] = new String[ttlRowCnt -1];
        
        
        for(int rowNo = 1 ; rowNo< ttlRowCnt;rowNo ++) {
        	
        	userNameData[rowNo-1] = ReadExcelFile.getCellValue(filname, "Sheet1", rowNo, 1);
        }
        
        return userNameData;
        
				
	}
	
	
	
	
	
}
