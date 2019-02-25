package com.primusbank.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.primusbank.constants.PrimusBankConstants;
import com.primusbank.library.BankerHomePage;
import com.primusbank.library.PrimusBankHomePAge;
import com.utils.*;

public class BankerLoginDDT extends PrimusBankConstants{
	@Test
	public void bankerLogin() throws Exception{
		int rc;
		String xlfile="D:\\qedge\\TestData.xlsx";
		String xlsheet="LoginData";
		String brname,uid,pwd;
		rc=Xlutils.getRowCount(xlfile, xlsheet);
		PrimusBankHomePAge phome=new PrimusBankHomePAge();
		BankerHomePage bhome=new BankerHomePage();
		for (int i = 1; i <=rc ; i++) 
		{
			brname=Xlutils.getCellData(xlfile, xlsheet, i, 0);
			uid=Xlutils.getCellData(xlfile, xlsheet, i, 1);
			pwd=Xlutils.getCellData(xlfile, xlsheet, i, 2);			
			boolean res=phome.bankerLogin(brname, uid, pwd);
			Assert.assertTrue(res);
			if (res) 
			{
				Xlutils.setCellData(xlfile, xlsheet, i, 3, "Pass");
				Xlutils.fillGreenColor(xlfile, xlsheet, i, 3);
			} else 
			{
				Xlutils.setCellData(xlfile, xlsheet, i, 3, "Fail");
				Xlutils.fillRedColor(xlfile, xlsheet, i, 3);
			}
			bhome.bankerLogout();
		}			

	}

}
