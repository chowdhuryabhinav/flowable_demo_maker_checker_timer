package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Feeds;

import com.example.demo.dto.ProcessInstanceResponse;
import com.example.demo.dto.TaskDetails;

@RestController
public class TaskController {
	
	@Autowired
	private UserTaskService userService;
	
	
	
	 @PostMapping("/feeds/process")
	    public ProcessInstanceResponse applyHoliday(@RequestBody Feeds feeds) {
	        return userService.feedsMastering(feeds);
	    }

	 @GetMapping("/maker/tasks")
	    public List<TaskDetails> getMakerTasks() {
	        return userService.getMakerTasks();
	    }
	 
	 @GetMapping("/checker/tasks")
	    public List<TaskDetails> getTasks() {
	        return userService.getCheckerTasks();
	    }
	 
	 @PostMapping("/update/feeds/{taskId}")
	 public void updateFeed(@PathVariable("taskId") String taskId,@RequestBody Feeds feeds) {
		 userService.updateFeedDetails(taskId, feeds);
		 
	 }
	 
	 @PostMapping("/checker/approve/{taskId}/{approved}")
	 public void approveFeed(@PathVariable("taskId") String taskId, @PathVariable("approved") Boolean approved) {
		 userService.approveFeeds(taskId, approved);
	 }
	 
}
