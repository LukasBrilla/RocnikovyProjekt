package sk.po.spse.beachclubapp.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.springframework.stereotype.Service;

import sk.po.spse.beachclubapp.entity.Pair;

@Service
public class ExcelService 
{
	
	@Autowired
	private PairService pairService;
	
	public void inputListInExcel(List<Pair> pairs, String tournamentName)
	{
		pairs = pairService.findAll();
		tournamentName = "Prešov Beachvolley Cup";
		try {
			HSSFWorkbook workbook = (HSSFWorkbook) HSSFWorkbookFactory.create(new File("D:\\BEACH\\BEACHCLUB PREŠOV\\VŠEOBECNÉ\\PAVÚKY\\EXCEL_PAVÚK_12.xls"));
			
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			
				HSSFRow row = sheet.getRow(3);
				row.getCell(2).setCellValue(pairs.get(0).getFirstPlayer().getName());
				row.getCell(5).setCellValue(pairs.get(0).getSecondPlayer().getName());
				row.getCell(8).setCellValue(pairs.get(0).getAllPoints());
				row.getCell(9).setCellValue("" + pairs.get(0).getFirstPlayer().getName() + " / " + pairs.get(0).getSecondPlayer().getName());
				
		
				HSSFRow rowa = sheet.getRow(4);
				rowa.getCell(2).setCellValue(pairs.get(1).getFirstPlayer().getName());
				rowa.getCell(5).setCellValue(pairs.get(1).getSecondPlayer().getName());
				rowa.getCell(8).setCellValue(pairs.get(1).getAllPoints());
				rowa.getCell(9).setCellValue("" + pairs.get(1).getFirstPlayer().getName() + " / " + pairs.get(1).getSecondPlayer().getName());
				
				HSSFRow rowaa = sheet.getRow(5);
				rowaa.getCell(2).setCellValue(pairs.get(2).getFirstPlayer().getName());
				rowaa.getCell(5).setCellValue(pairs.get(2).getSecondPlayer().getName());
				rowaa.getCell(8).setCellValue(pairs.get(2).getAllPoints());
				rowaa.getCell(9).setCellValue("" + pairs.get(2).getFirstPlayer().getName() + " / " + pairs.get(2).getSecondPlayer().getName());
				
			
			
			
			workbook.write();
		} 
		catch (EncryptedDocumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

