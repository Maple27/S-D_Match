package entity;

import java.util.List;

public class Department {
	
	private String id;
	private int limit;
	private List<String> tags;
	private List<String> activityTime;
	private int num;
	private List<Student> members;

	public Department(String id, int limit, 
			List<String> tabs, List<String> activityTime, List<Student> members) {
		this.id = id;
		this.limit = limit;
		this.tags = tabs;
		this.activityTime = activityTime;
		this.num = 0;
		this.members = members;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tabs) {
		this.tags = tabs;
	}

	public List<String> getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(List<String> activityTime) {
		this.activityTime = activityTime;
	}
	
	public int getTagsSize(){
		return tags.size();
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public List<Student> getMembers() {
		return members;
	}

	public void setMembers(List<Student> members) {
		this.members = members;
	}
	
}
