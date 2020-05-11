import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import java.nio.file.Paths
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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import java.nio.file.Path
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ConditionType

File htmlFile = Paths.get(RunConfiguration.getProjectDir()).resolve("a.html").toFile()
WebUI.openBrowser(htmlFile.toURI().toURL().toExternalForm())

TestObject tObj = new TestObject("myTestObject")
tObj.addProperty("xpath", ConditionType.EQUALS, 
	"//td[contains(normalize-space(),'Achternaam (zonder diakriet)')]"
	+ "/following-sibling::td[1]"
	+ "/table/tbody/tr/td/table/tbody/tr[1]/td[3]/span/input");

WebUI.verifyElementPresent(tObj, 5, FailureHandling.STOP_ON_FAILURE)
WebUI.modifyObjectProperty(tObj, "value", "As you like it")

WebUI.delay(3)
WebUI.closeBrowser()