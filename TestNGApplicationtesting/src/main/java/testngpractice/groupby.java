package testngpractice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class groupby {
	
	
	@BeforeTest
	public void beforetest() {
		System.out.println("BEfore");
	}
	
	@AfterTest
	
	public void Abeforetest() {
		System.out.println("After");
	}
	
 @Test(groups = "group")
 public void a1() {
	 System.out.println("group A 1");
 }
 
 
 @Test(groups = "group")
 public void a21() {
	 System.out.println("group A a21 depends On");
 }
 
 @Test(groups = "group")
 public void a2() {
	 System.out.println("group A 12");
 }
 
 @Test(groups = "group")
 public void a3() {
	 System.out.println("group A 13 dpended");
 }
 
 @Test(groups = "group")
 public void a4() {
	 System.out.println("group A 14");
 }
 
 @Test(groups = "group")
 public void a() {
	 System.out.println("group A 15");
 }
 
 @Test(groups = "group")
 public void a5() {
	 System.out.println("group A 16");
 }
 
 @Test(groups = "group")
 public void a6() {
	 System.out.println("group A 17");
 }
 
 
 @Test(groups = "oops")
 void AS() {
	 System.out.println(" oops 1 ");
 }
 
 @Test(groups = "oops")
 public void AS1() {
	 System.out.println("oops 2");
 }
 
 @Test(groups = "oops", dependsOnMethods = "a21")
 public void AS2() {
	 System.out.println(" oops 3 ");
 }
 
 @Test(groups = "oops" ,dependsOnMethods = "a21")
 public void AS3() {
	 System.out.println(" oops 4 ");
 }
 
 
}
