package entity;

import java.util.List;

public class Student {

	private String id;
	private List<String> freeTime;
	private List<String> interests;
	private List<String> wills;
	private int flag;
	private List<Integer> scores;

	public Student(String id, List<String> freeTime,
			List<String> interests, List<String> wills, List<Integer> scores){
		this.id = id;
		this.freeTime = freeTime;
		this.interests = interests;
		this.wills = wills;
		this.flag = 0;
		this.scores = scores;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public List<String> getFreeTime() {
		return freeTime;
	}
	
	public void setFreeTime(List<String> freeTime) {
		this.freeTime = freeTime;
	}
	
	public List<String> getInterests() {
		return interests;
	}
	
	public void setInterests(List<String> interests) {
		this.interests = interests;
	}
	
	public List<String> getWills() {
		return wills;
	}
	
	public void setWills(List<String> wills) {
		this.wills = wills;
	}
	
	public int getWillsSize(){
		return wills.size();
	}
	
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	
}
