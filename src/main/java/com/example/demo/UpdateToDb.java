package com.example.demo;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class UpdateToDb implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		// TODO Auto-generated method stub
		
		Boolean result = (Boolean) execution.getVariable("approved");
		System.out.println(execution.getVariable("username"));
		
		
		System.out.println("Updating to Db ....");
		System.out.println(result);
		
	}

}
