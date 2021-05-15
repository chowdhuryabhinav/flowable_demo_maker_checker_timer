package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Feeds;
import com.example.demo.dto.ProcessInstanceResponse;
import com.example.demo.dto.TaskDetails;

@Service
public class UserTaskService {
	 @Autowired
	 RuntimeService runtimeService;
	 

	 
	 @Autowired
	 TaskService taskService;
	 
	    @Autowired
	    ProcessEngine processEngine;
	 
	 public static final String TASK_CANDIDATE_GROUP = "managers";
	    public static final String PROCESS_DEFINITION_KEY = "timerDemo";
	    public static final String EMP_NAME = "Abhinav";
	   
	    
	    
	
	
	 
	 public ProcessInstanceResponse feedsMastering(Feeds feeds) {

	        Map<String, Object> variables = new HashMap<String, Object>();
	        variables.put("username", feeds.getUserName());
	        variables.put("email", feeds.getEmail());
	        variables.put("contact", feeds.getContact());

	        ProcessInstance processInstance =
	                runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);

	        return new ProcessInstanceResponse(processInstance.getId(), processInstance.isEnded());
	    }
	 
	  public List<TaskDetails> getMakerTasks() {
	        List<Task> tasks =  taskService.createTaskQuery().taskAssignee("maker").list();
	                 
	        List<TaskDetails> taskDetails = getTaskDetails(tasks);
	        

	        return taskDetails;
	    }

	    private List<TaskDetails> getTaskDetails(List<Task> tasks) {
	        List<TaskDetails> taskDetails = new ArrayList<>();
	        for (Task task : tasks) {
	            Map<String, Object> processVariables = taskService.getVariables(task.getId());
	            taskDetails.add(new TaskDetails(task.getId(), task.getName(), processVariables));
	        }
	        return taskDetails;
	    }
	    
		  public List<TaskDetails> getCheckerTasks() {
		        List<Task> tasks =  taskService.createTaskQuery().taskAssignee("checker").list();
		                 
		        List<TaskDetails> taskDetails = getTaskDetails(tasks);
		        

		        return taskDetails;
		    }

		    private List<TaskDetails> getCheckerTaskDetails(List<Task> tasks) {
		        List<TaskDetails> taskDetails = new ArrayList<>();
		        for (Task task : tasks) {
		            Map<String, Object> processVariables = taskService.getVariables(task.getId());
		            taskDetails.add(new TaskDetails(task.getId(), task.getName(), processVariables));
		        }
		        return taskDetails;
		    }

		     public void updateFeedDetails(String taskId,Feeds feeds) {
		    	 Map<String,Object> updatedFeed = new HashMap<>();
		    	 updatedFeed.put("username",feeds.getUserName());
		    	 updatedFeed.put("email",feeds.getEmail());
		    	 updatedFeed.put("contact",feeds.getContact());
		    	 
		    	 System.out.println(updatedFeed);
		    	 
		    	 taskService.complete(taskId,updatedFeed);
		    	 
		    	 
		     }
		     
		     public void approveFeeds(String taskId,Boolean approved) {
		    	 Map<String,Object> resultVariable = new HashMap<>();
		    	 resultVariable.put("approved",approved.booleanValue());
		    	 
		    	 taskService.complete(taskId,resultVariable);
		    	 
		     }

}
