package com.cg.register.stepdefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NaukriStepDefinitions {
private WebDriver driver;
	
	@Before(order=1)
	public void setupStepEnv1(){
		System.setProperty("webdriver.chrome.driver",
				"D:\\SatishTrainingData\\TrainingsTopicsWise\\SeleniumAndWebDriver\\ChromeDriver\\chromedriver.exe" );
		}
	
	@Given("^User wants to register in 'https://my\\.naukri\\.com/account/createaccount'$")
	public void user_wants_to_register_in_https_my_naukri_com_account_createaccount() throws Throwable {
		driver=new ChromeDriver();
		 driver.get("https://my.naukri.com/account/createaccount");
	}
	

	@When("^user selects on Register with us$")
	public void user_selects_on_Register_with_us() throws Throwable {
	}
		
	@When("^user selects I am a Frseher$")
	public void user_selects_I_am_a_Frseher() throws Throwable {
		WebElement searchField=driver.findElement(By.xpath("/html/body/div/form/div[1]/div/button"));
		Thread.sleep(2000);
		searchField.click();
	}

	@Then("^display the registration page 'https://my\\.naukri\\.com/account/register/basicdetails'$")
	public void display_the_registration_page_https_my_naukri_com_account_register_basicdetails() throws Throwable {
		}

	@Then("^enter name as 'Aishwarya Gopal' enter email Id as 'aishuprg(\\d+)@gmail\\.com' enter password as 'Godbless(\\d+)'enter mobilenumber as '(\\d+)'$")
	public void enter_name_as_Aishwarya_Gopal_enter_email_Id_as_aishuprg_gmail_com_enter_password_as_Godbless_enter_mobilenumber_as(int arg1, int arg2, int arg3) throws Throwable {
		WebElement searchField=driver.findElement(By.xpath("//*[@id=\"fname\"]"));
		Thread.sleep(600);
		searchField.sendKeys("Aishwarya GopalPrg");
		
		WebElement searchField1=driver.findElement(By.id("email"));
		Thread.sleep(600);
		searchField1.sendKeys("asasasasas12345666655663969@gmail.com");
		
		WebElement searchField11=driver.findElement(By.name("password"));
		Thread.sleep(600);
		searchField11.sendKeys("Godbless6");
		
		WebElement searchField111=driver.findElement(By.name("number"));
		searchField111.sendKeys("9898989898");
	}

	@Then("^select current location as 'Chennai'$")
	public void select_current_location_as_Chennai() throws Throwable {
		WebElement searchField=driver.findElement(By.xpath("//*[@id=\"basicDetailForm\"]/resman-location/div/div/div[1]/div/div[1]/ul/li/div/label/input"));
		Thread.sleep(600);
		searchField.sendKeys("Chennai");
	}

	@Then("^user uploads resume$")
	public void user_uploads_resume() throws Throwable {
	   WebElement upload =driver.findElement(By.xpath("//*[@id=\"basicDetailForm\"]/resman-uploader/div/div[1]/span[1]/input"));
	   Thread.sleep(2000);
	   upload.sendKeys("D:\\Aishwarya-Core java\\Resume\\resume.pdf");
	   upload.submit();
	}

	@Then("^user clicks on register now$")
	public void user_clicks_on_register_now() throws Throwable {
		WebElement upload =driver.findElement(By.xpath("//*[@id=\"basicDetailForm\"]/div[5]/div/div/div[2]/button"));
      upload.click();
	}

	@Then("^display the 'https://my\\.naukri\\.com/account/register/education'$")
	public void display_the_https_my_naukri_com_account_register_education() throws Throwable {
		 Thread.sleep(2000);
		driver.navigate().refresh();
	}

	@Then("^user selects highest qualification as 'Graduation/Diploma'enter course as 'BTech/B\\.E'$")
	public void user_selects_highest_qualification_as_Graduation_Diploma_enter_course_as_BTech_B_E() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section[1]/edu-qualification/div/div[1]/div/div/div[1]/ul/li/div/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/edu-qualification/div/div[1]/div/div/div[2]/ul/li[3]/div/div/span")).click();
		
		driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/div/edu-course/div/div[1]/div/div/div[1]/ul/li/div/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/div/edu-course/div/div[1]/div/div/div[2]/ul/li[17]/div/div/span")).click();
}

	@Then("^enter specialization as 'Electronics/TeleCommunication'$")
	public void enter_specialization_as_Electronics_TeleCommunication() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/div/edu-spec/div/div[1]/div/div/div[1]/ul/li/div/label/input")).click();
		
		driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/div/edu-spec/div/div[1]/div/div/div[2]/ul/li[11]/div/div/span")).click();
	}

	@Then("^enter University/College as 'Saveetha Engineering College,Chennai'$")
	public void enter_University_College_as_Saveetha_Engineering_College_Chennai() throws Throwable {
	WebElement searchField=driver.findElement(By.xpath("//*[@id=\"institute_0\"]"));
		Thread.sleep(2000);
		searchField.sendKeys("SRM university (SRMU)");
		searchField.submit();
	
	}

	@Then("^user selects course type as 'Full Time'$")
	public void user_selects_course_type_as_Full_Time() throws Throwable {
   WebElement searchField=driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/div/div/div/div/div/label[1]"));
   searchField.click();
	}

	@Then("^user selects passing year as '(\\d+)'$")
	public void user_selects_passing_year_as(int arg1) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/div/edu-passing/div/div[1]/div/div/div[1]/ul/li/div/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/div/edu-passing/div/div[1]/div/div/div[2]/ul/li[5]/div/div/span")).click();
		
	}

	@Then("^enter skills as 'Java'$")
	public void enter_skills_as_Java() throws Throwable {
	WebElement src=	driver.findElement(By.xpath("//*[@id=\"selSkillCont\"]/div/ul/li/suggestor/div/div/input"));
  src.sendKeys("Java");
		src.submit();
		
		
	}

	@Then("^enter continue$")
	public void enter_continue() throws Throwable {
		WebElement searchField=driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/div/div/div/button"));
		searchField.click();
}

	@Then("^display the 'https://www\\.firstnaukri\\.com/freshersmnj/index\\.php/RegisterIntermediate/register/portid/(\\d+)e(\\d+)eaff(\\d+)a(\\d+)e(\\d+)c(\\d+)fb(\\d+)cedd(\\d+)d(\\d+)e(\\d+)af(\\d+)a(\\d+)d(\\d+)d(\\d+)c(\\d+)ea(\\d+)d(\\d+)d(\\d+)ac(\\d+)f(\\d+)f(\\d+)f/othersrcp/(\\d+)/brijjUser/(\\d+)/inothersrcp/(\\d+)/RELOAD/(\\d+)'$")
	public void display_the_https_www_firstnaukri_com_freshersmnj_index_php_RegisterIntermediate_register_portid_e_eaff_a_e_c_fb_cedd_d_e_af_a_d_d_c_ea_d_d_ac_f_f_f_othersrcp_brijjUser_inothersrcp_RELOAD(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, int arg19, int arg20, int arg21, int arg22, int arg23, int arg24, int arg25) throws Throwable {
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	@Then("^user selects Grading System as 'Scale (\\d+) grading system'$")
	public void user_selects_Grading_System_as_Scale_grading_system(int arg1) throws Throwable {
	
		driver.findElement(By.xpath("//*[@id=\"score_type[]\"]/option[2]")).click();
}
	@Then("^enter marks as '(\\d+)'$")
	public void enter_marks_as(int arg1) throws Throwable {
		int size=driver.findElements(By.xpath("//*[@id=\"score[]\"]")).size();
		
		WebElement searchField=driver.findElements(By.name("SCORE[]")).get(size-1);
		Thread.sleep(2000);
		searchField.sendKeys("9.6");
		searchField.click();
	}

	@Then("^selects college/insitute name as 'Saveetha Engineering College,Chennai'$")
	public void selects_college_insitute_name_as_Saveetha_Engineering_College_Chennai() throws Throwable {
	WebElement searchField=driver.findElement(By.xpath("//*[@id=\"institute_1\"]"));
		
		searchField.sendKeys("Nall"); 
		Thread.sleep(2000);
		WebElement searchField1=driver.findElement(By.xpath("//*[@id=\"SUGGESTOR_DATA_INSTITUTE_1\"]/i[3]"));
		searchField1.click();

	}

	@Then("^selects Class XII as 'TamilNadu' selects marks as '(\\d+)-(\\d+)\\.(\\d+)%' selects year as '(\\d+)' selects medium as 'English'$")
	public void selects_Class_XII_as_TamilNadu_selects_marks_as_selects_year_as_selects_medium_as_English(int arg1, int arg2, int arg3, int arg4) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"board[]\"]/option[26]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"marks12\"]/select/option[14]")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"school_completion_year[]\"]/option[6]")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"medium[]\"]/option[4]")).click();
		
	}

	@Then("^enter maths marks as '(\\d+)' enter english marks as '(\\d+)'$")
	public void enter_maths_marks_as_enter_english_marks_as(int arg1, int arg2) throws Throwable {
		WebElement searchField=driver.findElement(By.xpath("//*[@id=\"sub_marks\"]/input[1]"));
		Thread.sleep(2000);
		searchField.sendKeys("90");
		
		
		WebElement searchField1=driver.findElement(By.xpath("//*[@id=\"sub_marks\"]/input[2]"));
		Thread.sleep(2000);
		searchField1.sendKeys("90");
	}

	@Then("^selects Class X as 'TamilNadu' selects marks as '(\\d+)-(\\d+)\\.(\\d+)%' selects year as '(\\d+)' selects medium as 'English'$")
	public void selects_Class_X_as_TamilNadu_selects_marks_as_selects_year_as_selects_medium_as_English(int arg1, int arg2, int arg3, int arg4) throws Throwable {
	
	 int size1=	driver.findElements(By.xpath("//*[@id=\"board[]\"]")).size();
	 WebElement selectElement=driver.findElements(By.id("board[]")).get(size1-1);
	  Thread.sleep(2000);
		selectElement.sendKeys("Tamil Nadu");
		
		
		driver.findElement(By.xpath("//*[@id=\"marks10\"]/select/option[13]")).click();
		
		
		int size2=driver.findElements(By.xpath("//*[@id=\"school_completion_year[]\"]")).size();
		WebElement selectElement1=driver.findElements(By.id("school_completion_year[]")).get(size2-1);
		Thread.sleep(2000);
			selectElement1.sendKeys("2012");
		
			int size3=driver.findElements(By.xpath("//*[@id=\"medium[]\"]")).size();
			WebElement selectElement2=driver.findElements(By.id("medium[]")).get(size3-1);
			Thread.sleep(2000);
				selectElement2.sendKeys("English");
	}

	@Then("^selects gender as 'Female' selects Hometown  as 'Chennai'$")
	public void selects_gender_as_Female_selects_Hometown_as_Chennai() throws Throwable {
		driver.findElement(By.xpath("/html/body/form/div[2]/div[4]/table[3]/tbody/tr[1]/td[2]/span/input[2]")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"hometown\"]/option[5]")).click();
		
	}

	@Then("^selects date of birth as '(\\d+)' '(\\d+)' '(\\d+)'$")
	public void selects_date_of_birth_as(int arg1, int arg2, int arg3) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"birth_dt_dd\"]/option[2]")).click();
		
		
		
		driver.findElement(By.xpath("//*[@id=\"birth_dt_mm\"]/option[6]")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"birth_dt_yyyy\"]/option[9]")).click();
		
	}

	@Then("^selects preffered location as 'Anywhere in India'$")
	public void selects_preffered_location_as_Anywhere_in_India() throws Throwable {
	
		driver.findElement(By.xpath("//*[@id=\"235\"]")).click();
	
	}

	@Then("^selects 'Submit and continue with naukri registration'$")
	public void selects_Submit_and_continue_with_naukri_registration() throws Throwable {
		WebElement searchField=driver.findElement(By.xpath("//*[@id=\"btnsubmit\"]"));
		//Thread.sleep(2000);
		
		searchField.click();
	}

	@Then("^display 'https://my\\.naukri\\.com/account/register/profilecompletion\\?showp(\\d+)=(\\d+)&brijjUser=(\\d+)&id=&unregId=&pm='$")
	public void display_https_my_naukri_com_account_register_profilecompletion_showp_brijjUser_id_unregId_pm(int arg1, int arg2, int arg3) throws Throwable {
		Thread.sleep(2000);
		driver.navigate().refresh();
		   
	}

	@Then("^user uploads photo$")
	public void user_uploads_photo() throws Throwable {
		 	}

	@Then("^user enters Describe your professional background in one line$")
	public void user_enters_Describe_your_professional_background_in_one_line() throws Throwable {

}

	@Then("^user selects industry as 'IT Software/IT Services' user selects functional area as 'IT- CLIENT SERVER' user selects role as 'System/Analyst'$")
	public void user_selects_industry_as_IT_Software_IT_Services_user_selects_functional_area_as_IT_CLIENT_SERVER_user_selects_role_as_System_Analyst() throws Throwable {
	    
		driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-industry/div/div/div/div[1]/ul/li/div/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-industry/div/div/div/div[2]/ul/li[34]/div/div/span")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-farea/div[1]/div/div/div[1]/ul/li/div/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-farea/div[1]/div/div/div[2]/ul/li[16]/div/div/span")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-farea/div[2]/div/div/div/div[1]/ul/li/div/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-farea/div[2]/div/div/div/div[2]/ul/li[2]/div/div/span")).click();
		
	}

	@Then("^user selects preferred location as 'South India' user selects desired type as 'Both' user selects desired emplpoyemnt type as 'Both'$")
	public void user_selects_preferred_location_as_South_India_user_selects_desired_type_as_Both_user_selects_desired_emplpoyemnt_type_as_Both() throws Throwable {
	    
	
		driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-preflocation/div/div/div[1]/div[1]/ul/li/div/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-preflocation/div/div/div[1]/div[2]/ul/li[2]/div/div/span")).click();
	
		WebElement searchField=driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/div[2]/div/div/div/label[3]"));
		searchField.click();
		
		WebElement searchField1=driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/div[3]/div/div/div/label[3]"));
		searchField1.click();
	
	}

	@Then("^enter it skills$")
	public void enter_it_skills() throws Throwable {
	   WebElement element=driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/div[4]/div/div[2]/resman-itskill/div/suggestor/div/div/input"));
	   element.sendKeys("Msword");
	   
	   WebElement element1=driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/div[4]/div/div[2]/resman-itskill/div/input"));
	   element1.sendKeys("4");
	   
	   driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/div[4]/div/div[2]/resman-itskill/div/div[1]/div[1]/ul/li/div/label/input")).click();
	   driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/div[4]/div/div[2]/resman-itskill/div/div[1]/div[2]/ul/li/div/div/span")).click();
	   
	   
	   driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/div[4]/div/div[2]/resman-itskill/div/div[2]/div[1]/ul/li/div/label/input")).click();
	   driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/div[4]/div/div[2]/resman-itskill/div/div[2]/div[2]/ul/li[1]/div/div/span")).click();
	   
	  
	}

	@Then("^enter date of birth$")
	public void enter_date_of_birth() throws Throwable {
		 driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-dob/div/div/div/div[1]/div[1]/ul/li/div/label/input")).click();
		   driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-dob/div/div/div/div[1]/div[2]/ul/li[4]/div/div/span")).click();
		   
		   
		   driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-dob/div/div/div/div[2]/div[1]/ul/li/div/label/input")).click();
		   driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-dob/div/div/div/div[2]/div[2]/ul/li[5]/div/div/span")).click();
		   
		   
		   driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-dob/div/div/div/div[3]/div[1]/ul/li/div/label/input")).click();
		   driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-dob/div/div/div/div[3]/div[2]/ul/li[1]/div/div/span")).click();
	}

	@Then("^enter gender as 'Female'$")
	public void enter_gender_as_Female() throws Throwable {
		WebElement searchField=driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/div[5]/div/div/div/label[2]"));
		searchField.click();
	}

	@Then("^enter martial status AS 'single' enter email address$")
	public void enter_martial_status_AS_single_enter_email_address() throws Throwable {
		 driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-marital/div/div/div/div[1]/ul/li/div/label/input")).click();
		   driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-marital/div/div/div/div[2]/ul/li[1]/div/div/span")).click();
	
		   WebElement searchField=driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/div[6]/div/textarea"));
			Thread.sleep(600);
			searchField.sendKeys("Muthamil Nagar");
	
	}

	@Then("^enter city as 'Chennai' enter pin code as '(\\d+)' enter Select the countries where you are authorized to work as 'India'$")
	public void enter_city_as_Chennai_enter_pin_code_as_enter_Select_the_countries_where_you_are_authorized_to_work_as_India(int arg1) throws Throwable {
	   
		 WebElement searchField=driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/div[7]/div/div[1]/input"));
			Thread.sleep(600);
			searchField.sendKeys("Chennai");
			
			
			 WebElement searchField1=driver.findElement(By.xpath("//*[@id=\"pincode\"]"));
				Thread.sleep(600);
				searchField1.sendKeys("600118");
				
				
				driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-countries/div/div/div[1]/div[1]/ul/li/div/label/input")).click();
				driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-countries/div/div/div[1]/div[2]/ul/li[1]/div/div/span")).click();
	}

	@Then("^enter Work status for USA as 'HI VISA' enter Differently Abled as 'No'$")
	public void enter_Work_status_for_USA_as_HI_VISA_enter_Differently_Abled_as_No() throws Throwable {
	   
		driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-workpermit/div/div/div[1]/div[1]/ul/li/div/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-workpermit/div/div/div[1]/div[2]/ul/li[1]/div/div/span")).click();
		
		
		WebElement searchField=driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/resman-disability/div/div/div/div/label[2]"));
		searchField.click();
	}

	@Then("^click submit button$")
	public void click_submit_button() throws Throwable {
WebElement searchField=driver.findElement(By.xpath("//*[@id=\"profileCompleteForm\"]/div[8]/div[1]/div/button"));
		
		searchField.click();
	}


	@Then("^display 'https://www\\.naukri\\.com/free-job-alerts\\?src=DRES'$")
	public void display_https_www_naukri_com_free_job_alerts_src_DRES() throws Throwable {
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	@Then("^user enter key skills enter location$")
	public void user_enter_key_skills_enter_location() throws Throwable {
		 WebElement searchField=driver.findElement(By.xpath("//*[@id=\"Sug_kwdsugg\"]"));
			Thread.sleep(600);
			searchField.sendKeys("Java");
			
			 WebElement searchField1=driver.findElement(By.xpath("//*[@id=\"Sug_locsugg\"]"));
				Thread.sleep(600);
				searchField1.sendKeys("Chennai");
	}

	@Then("^user enter Job name$")
	public void user_enter_Job_name() throws Throwable {
		 WebElement searchField=driver.findElement(By.xpath("//*[@id=\"nyja\"]"));
			Thread.sleep(600);
			searchField.sendKeys("Alert");
	}

	@Then("^enter submit$")
	public void enter_submit() throws Throwable {
WebElement searchField=driver.findElement(By.xpath("//*[@id=\"cjaSubmit\"]"));
		
		searchField.click();
	}

	@Then("^'https://www\\.naukri\\.com/alert/results\\?aId=dd(\\d+)ac(\\d+)c(\\d+)f(\\d+)d(\\d+)ca(\\d+)fcc(\\d+)c(\\d+)fd(\\d+)fcf(\\d+)e(\\d+)f(\\d+)cdb(\\d+)d(\\d+)b(\\d+)a(\\d+)c(\\d+)dcacf(\\d+)fb(\\d+)b(\\d+)be(\\d+)bd(\\d+)d(\\d+)da(\\d+)ba(\\d+)ba(\\d+)faf(\\d+)ae(\\d+)b(\\d+)c(\\d+)cd(\\d+)a(\\d+)cc(\\d+)cde(\\d+)c(\\d+)ce(\\d+)ddf(\\d+)d(\\d+)fa(\\d+)cacf(\\d+)d(\\d+)&toBedel='$")
	public void https_www_naukri_com_alert_results_aId_dd_ac_c_f_d_ca_fcc_c_fd_fcf_e_f_cdb_d_b_a_c_dcacf_fb_b_be_bd_d_da_ba_ba_faf_ae_b_c_cd_a_cc_cde_c_ce_ddf_d_fa_cacf_d_toBedel(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, int arg19, int arg20, int arg21, int arg22, int arg23, int arg24, int arg25, int arg26, int arg27, int arg28, int arg29, int arg30, int arg31, int arg32, int arg33, int arg34, int arg35, int arg36, int arg37, int arg38, int arg39, int arg40, int arg41) throws Throwable {
		String actualTitle=driver.getTitle();
		   Assert.assertEquals(" Job Alert Created - Naukri.com ", actualTitle);
	}


}
