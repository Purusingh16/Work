package selenium;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class DatePicker {
 
        public static void main(String[] args) throws InterruptedException {
                String dateTime ="07/06/2017";   
                WebDriver driver = new FirefoxDriver();
                driver.manage().window().maximize();  
                driver.get("http://www.makemytrip.com/");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //---open calender
                driver.findElement(By.xpath(".//*[@id='start_date_sec']/span[1]/span[1]")).click();
                Thread.sleep(2000);
 
                @SuppressWarnings("unused")
                WebElement nextLink = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/div/a/span"));
                //button to click in center of calendar header
                WebElement midLink = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/div/div"));
                //button to move previous month in calendar
                @SuppressWarnings("unused")
                WebElement previousLink = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/div/a/span"));
 
                //=== Year Difference====
                String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");
 
                int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);
                System.out.println(yearDiff);
                midLink.click();
                if (yearDiff == 0){
                        System.out.println(" I am in Zero Loop");
                        //----- Month Diff ---
                        int monthDiff = Integer.parseInt(date_dd_MM_yyyy[1])- Calendar.getInstance().get(Calendar.MONTH)-1;
                        System.out.println(monthDiff);
                        for (int i=0; i<monthDiff; i++){
                                driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
                        }
                        List<WebElement> rowList = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr"));
                        System.out.println("Rows Count "+rowList.size());
                        List<WebElement> colList = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[2]/td"));
                        System.out.println("Cols Count "+colList.size());      
                        int z =0;
                        for (int r=1; r<=rowList.size(); r++){
                                z = r;
                                for (int c=1; c<(colList.size()+1); c++){
                                        String dateINT = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr["+r+"]/td["+c+"]")).getText();
                                        int expectedDate = Integer.parseInt(date_dd_MM_yyyy[0]);
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("");
                                        sb.append(expectedDate);
                                        String strI = sb.toString();
                                        if (dateINT.equalsIgnoreCase(strI)){
                                                driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr["+r+"]/td["+c+"]")).click();
                                                z=0;
                                                break;
                                        }
                                }
                                if (z ==0){
                                        break;
                                }
                        }
                }else{
                        System.out.println(" I am not in Zero Loop");
                        int monthDiff = (12- Calendar.getInstance().get(Calendar.MONTH)-1) + Integer.parseInt(date_dd_MM_yyyy[1]);
                        System.out.println("Month Diff "+monthDiff);
 
                        if (Integer.parseInt(date_dd_MM_yyyy[1]) == (Calendar.getInstance().get(Calendar.MONTH)+1)){
                                System.out.println(" I Am in Same Month with Year Diff");
                                for (int i=0; i<monthDiff-1; i++){
                                        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
                                }
 
                                List<WebElement> rowList = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr"));
                                System.out.println("Rows Count "+rowList.size());
                                List<WebElement> colList = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[2]/td"));
                                System.out.println("Cols Count "+colList.size());      
                                int z =0;
                                for (int r=1; r<(rowList.size()+1); r++){
                                        z = r;
                                        for (int c=1; c<(colList.size()+1); c++){
                                                String dateINT = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr["+r+"]/td["+c+"]")).getText();
                                                int expectedDate = Integer.parseInt(date_dd_MM_yyyy[0]);
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("");
                                                sb.append(expectedDate);
                                                String strI = sb.toString();
                                                if (dateINT.equalsIgnoreCase(strI)){
                                                        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr["+r+"]/td["+c+"]")).click();
                                                        z=0;
                                                        break;
                                                }
                                        }
                                        if (z ==0){
                                                break;
                                        }
                                }
 
                        }else{
                                System.out.println(" I Am in Diff Month with Year Diff");
                                for (int i=0; i<monthDiff; i++){
                                        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
                                }
                                List<WebElement> rowList = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr"));
                                System.out.println("Rows Count "+rowList.size());
                                List<WebElement> colList = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[2]/td"));
                                System.out.println("Cols Count "+colList.size());      
                                int z =0;
                                for (int r=1; r<(rowList.size()+1); r++){
                                        z = r;
                                        for (int c=1; c<(colList.size()+1); c++){
                                                String dateINT = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr["+r+"]/td["+c+"]")).getText();
                                                int expectedDate = Integer.parseInt(date_dd_MM_yyyy[0]);
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("");
                                                sb.append(expectedDate);
                                                String strI = sb.toString();
                                                if (dateINT.equalsIgnoreCase(strI)){
                                                        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr["+r+"]/td["+c+"]")).click();
                                                        z=0;
                                                        break;
                                                }
                                        }
                                        if (z ==0){
                                                break;
                                        }
                                }
                        }
 
                }
                //driver.close();
 
        }
 
}