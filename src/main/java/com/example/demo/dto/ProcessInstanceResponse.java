package com.example.demo.dto;




public class ProcessInstanceResponse {
  String processId;
  boolean isEnded;
  
  
@Override
public String toString() {
	return "ProcessInstanceResponse [processId=" + processId + ", isEnded=" + isEnded + "]";
}
public ProcessInstanceResponse(String processId, boolean isEnded) {
	super();
	this.processId = processId;
	this.isEnded = isEnded;
}
public String getProcessId() {
	return processId;
}
public void setProcessId(String processId) {
	this.processId = processId;
}
public boolean isEnded() {
	return isEnded;
}
public void setEnded(boolean isEnded) {
	this.isEnded = isEnded;
}
  
  
}
