package testngpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Asssertions {
  @Test
  public void f() {
	  
	  String str1= new String("TestNG");
	  String str2=new String("TestNG");
	  String str3= null;
	  String str4="TestNG";
	  String str5="TestNG";
	  String str6=new String("NOt_TestNG");
	  
	  
	  Assert.assertEquals(str1, str2);
	  System.out.println("valid");
	  
	  Assert.assertSame(str5, str6);
	  System.out.println("va");
	  
	  
  }
}
