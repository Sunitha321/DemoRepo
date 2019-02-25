package com.primusbank.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.primusbank.constants.PrimusBankConstants;

import com.primusbank.library.BankerHomePage;
import com.primusbank.library.PrimusBankAdminPage;
import com.primusbank.library.PrimusBankHomePAge;

import com.utils.Xlutils;

public class PrimusBankAdminTest extends PrimusBankConstants 
{

	
	@Test
	public void batchTest() throws IOException
	{
		
		String keywordfile="E:\\QEdge_Selenium\\DataDrivenFramework\\src\\com\\primusbank\\testdata\\PrimusBankKeywords.xlsx";
		String tcsheet="TestCases";
		String tssheet="TestSteps";
		String tcid,tstcid,tcexeflg,keyword,tsres,tcres;
		int tccount,tscount;
		boolean res=false;
		
		
		PrimusBankHomePAge phome=new PrimusBankHomePAge();
		PrimusBankAdminPage ahome=new PrimusBankAdminPage();
		BankerHomePage bhome=new BankerHomePage();
		
		
		tccount=Xlutils.getRowCount(keywordfile, tcsheet);
		tscount=Xlutils.getRowCount(keywordfile, tssheet);
		for (int i = 1; i <=tccount ; i++) 
		{
			tcid=Xlutils.getCellData(keywordfile, tcsheet, i, 0);
			tcexeflg=Xlutils.getCellData(keywordfile, tcsheet, i, 2);
			if (tcexeflg.equalsIgnoreCase("Y")) 
			{
				for (int j = 1; j <=tscount; j++) 
				{
					tstcid=Xlutils.getCellData(keywordfile, tssheet, j, 0);
					if (tstcid.equalsIgnoreCase(tcid)) 
					{
						keyword=Xlutils.getCellData(keywordfile, tssheet, j, 4);
						switch (keyword.toLowerCase()) 
						{
						case "adminlogin":
							String uid=Xlutils.getCellData(keywordfile, tssheet, j, 5);
							String pwd=Xlutils.getCellData(keywordfile, tssheet, j, 6);
							res=phome.adminLogin(uid, pwd);							
							break;

						case "adminlogout":
							res=ahome.adminLogout();
							break;
						case "bankerlogin":
							String brname=Xlutils.getCellData(keywordfile, tssheet, j, 5);
							uid=Xlutils.getCellData(keywordfile, tssheet, j, 6);
							pwd=Xlutils.getCellData(keywordfile, tssheet, j, 7);							
							res=phome.bankerLogin(brname, uid, pwd);
							break;
						case "bankerlogout":
							res=bhome.bankerLogout();
							break;
						}
						if (res) 
						{
							tsres="Pass";
							Xlutils.setCellData(keywordfile, tssheet, j, 3, tsres);
							Xlutils.fillGreenColor(keywordfile, tssheet, j, 3);
						} else 
						{
							tsres="Fail";
							Xlutils.setCellData(keywordfile, tssheet, j, 3, tsres);
							Xlutils.fillRedColor(keywordfile, tssheet, j, 3);
						}
						
						tcres=Xlutils.getCellData(keywordfile, tcsheet, i, 3);
						if (!tcres.equalsIgnoreCase("fail")) 
						{
							Xlutils.setCellData(keywordfile, tcsheet, i, 3, tsres);
						}
						tcres=Xlutils.getCellData(keywordfile, tcsheet, i, 3);
						if (tcres.equalsIgnoreCase("Pass"))
						{
							Xlutils.fillGreenColor(keywordfile, tcsheet, i, 3);
						}else
						{
							Xlutils.fillRedColor(keywordfile, tcsheet, i, 3);
						}
						
						
						
						
					}
				}	
				
				
				
				
			}else
			{
				Xlutils.setCellData(keywordfile, tcsheet, i, 3, "Blocked");
				Xlutils.fillRedColor(keywordfile, tcsheet, i, 3);
			}
		}
		
		
		
		
		
	}
	
	
	
	
	
}
