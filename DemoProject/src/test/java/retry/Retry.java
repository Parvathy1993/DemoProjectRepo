package retry; 
//Purpose: Re-execute a failed test case automatically up to a certain limit.
//What is IRetryAnalyzer?
//"IRetryAnalyzer is an interface in TestNG that allows us to automatically re-run a failed test case. It's useful for handling flaky tests (e.g., due to network delay or element load issues)."

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer { //IRetryAnalyzer--is an interface which helps to rerun the failed testcases(element load issues or network issues) 
	int counter = 0; 
	int retryLimit = 2;
	
	public boolean retry(ITestResult result) { //invoke when testcase fails

		if(counter < retryLimit) 
		{ 
			counter++; 
			return true; //reexecution
		} 
		return false; //stop execution
	}

}

/*If a test fails:
Attempt 1: Test fails → counter = 0 → retry() returns true
Attempt 2: Retry test → counter = 1 → still less than 2 → retry() returns true
Attempt 3: Retry again → counter = 2 → not less than retry limit → retry() returns false*/
