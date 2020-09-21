Feature: Naukri Registrartion

Scenario: Freshers Registration  
Given User is on Nakuri.com web site 
When user selects on Register with us And selects I am a Frseher 
Then freshers Registration should display

And enter name as 'Aishwarya Gopal' enter email Id as 'aishuprg97@gmail.com' enter password as 'Godbless6'enter mobilenumber as '8608327394'
And  select current location as 'Chennai'
 And user uploads resume
 And user clicks on register now
 Then display the 'https://my.naukri.com/account/register/education'
 
 And user selects highest qualification as 'Graduation/Diploma'enter course as 'BTech/B.E'
 And enter specialization as 'Electronics/TeleCommunication'
 And enter University/College as 'Saveetha Engineering College,Chennai'
 And user selects course type as 'Full Time'
 And user selects passing year as '2018'
 And enter skills as 'Java'
 And enter continue
 Then display the 'https://www.firstnaukri.com/freshersmnj/index.php/RegisterIntermediate/register/portid/7e4855226eaff17a0e147c96fb6cedd650d2431e26af56a3d9d9c995ea89628492d2d6ac5f21f68f/othersrcp/1002/brijjUser/2/inothersrcp/22536/RELOAD/1'
 
 
 And user selects Grading System as 'Scale 10 grading system'
 And enter marks as '8'
 And selects college/insitute name as 'Saveetha Engineering College,Chennai'
 And selects Class XII as 'TamilNadu' selects marks as '85-89.9%' selects year as '2014' selects medium as 'English'
 And enter maths marks as '90' enter english marks as '90'
 
 

 And selects Class X as 'TamilNadu' selects marks as '85-89.9%' selects year as '2012' selects medium as 'English'

And selects gender as 'Female' selects Hometown  as 'Chennai'
And selects date of birth as '01' '05' '1997'
 And selects preffered location as 'Anywhere in India'
 And selects 'Submit and continue with naukri registration'
 
 
 Then display 'https://my.naukri.com/account/register/profilecompletion?showp3=1&brijjUser=3&id=&unregId=&pm='
 And user uploads photo 
 And user enters Describe your professional background in one line
 And user selects industry as 'IT Software/IT Services' user selects functional area as 'IT- CLIENT SERVER' user selects role as 'System/Analyst'
 And user selects preferred location as 'South India' user selects desired type as 'Both' user selects desired emplpoyemnt type as 'Both'
 And enter it skills
 And enter date of birth
 And enter gender as 'Female'
 And enter martial status AS 'single' enter email address
 And enter city as 'Chennai' enter pin code as '600118' enter Select the countries where you are authorized to work as 'India'
 And enter Work status for USA as 'HI VISA' enter Differently Abled as 'No'
 And click submit button
 Then display 'https://www.naukri.com/free-job-alerts?src=DRES' 
 
 
And user enter key skills enter location
And user enter Job name 
And enter submit 
Then 'https://www.naukri.com/alert/results?aId=dd211ac4c2f1d1194ca025fcc0c7fd8fcf28e3f09cdb8d7b2148a9c8dcacf427310fb67b796be40bd2298d174da4338ba892ba1faf0792ae6910835b55c521cd9a86cc384cde9c374ce54846ddf52d3301fa009cacf491d8&toBedel='
