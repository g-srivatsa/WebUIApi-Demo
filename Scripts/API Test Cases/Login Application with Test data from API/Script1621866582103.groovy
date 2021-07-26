import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//WebUI.callTestCase(findTestCase('API Test Cases/Get User Details'), [:], FailureHandling.STOP_ON_FAILURE)
response = WS.sendRequest(findTestObject('API Object Repository/Get Users'))

WS.verifyResponseStatusCode(response, 200)

usrName = WS.getElementPropertyValue(response, 'data[3].first_name')

WebUI.callTestCase(findTestCase('Web Test Cases/CURA Healthcare Service/Appointment/Open Browser'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Web Test Cases/CURA Healthcare Service/Appointment/Click on Login Link'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Web Object Repository/CURA Healthcare Service/Login Page/input_Username'), usrName)

WebUI.sendKeys(findTestObject('Web Object Repository/CURA Healthcare Service/Login Page/input_Password'), GlobalVariable.password)

WebUI.click(findTestObject('Web Object Repository/CURA Healthcare Service/Login Page/button_Login'))

WebUI.verifyElementText(findTestObject('Web Object Repository/CURA Healthcare Service/Appointment Page/Make Appointment'), 
    'Make Appointment')

