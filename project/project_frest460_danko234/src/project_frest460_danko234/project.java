package project_frest460_danko234;

import java.math.BigDecimal;

public class project {
	
	String customerid;
	String projectid;
	String startdate;
	String enddate;
	String status;
	String description;
	String cost;
	String time;
	String manager;
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public project(String customerid, String projectid, String startdate,
			String enddate, String status, String description, String cost,
			String time, String manager) {
		super();
		this.customerid = customerid;
		this.projectid = projectid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.status = status;
		this.description = description;
		this.cost = cost;
		this.time = time;
		this.manager = manager;
	}
	

}
