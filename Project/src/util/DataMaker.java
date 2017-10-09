package util;

import java.util.ArrayList;
import java.util.Random;

import bean.InputBean;
import bean.InputBean.DepartmentsBean;
import bean.InputBean.StudentsBean;

public class DataMaker {

	private InputBean inputBean = new InputBean();
	private String[] departmentID = {"D001","D002","D003","D004","D005","D006","D007"
		,"D008","D009","D010","D011","D012","D013","D014","D015","D016","D017","D018","D019","D020",};
	private String[] departmentTags = {"study","film","reading","football","dance","programming","chess","English","basketball","music"};
	private String[] departmentTimes = {"Mon","Tues","Wed","Thur","Fri","Sat","Sun"};
	
	public void setData(){
		Random random = new Random();
		ArrayList<DepartmentsBean> departmentsBeans = new ArrayList<>();
		ArrayList<StudentsBean> studentsBeans = new ArrayList<>();
		for(int i=0;i<20;i++){
			DepartmentsBean departmentsBean = new DepartmentsBean();
			departmentsBean.setDepartment_no(departmentID[i]);
			int memberNum = random.nextInt()%6;
			if(memberNum<0) memberNum*=-1;
			memberNum+=10;
			departmentsBean.setMember_limit(memberNum);
			
			int tagsNum = random.nextInt()%6;
			if(tagsNum<0) tagsNum*=-1;
			tagsNum+=2;
			int timesNum = random.nextInt()%5;
			if(timesNum<0) timesNum*=-1;
			timesNum++;
			ArrayList<String> list = new ArrayList<>();
			ArrayList<String> list2 = new ArrayList<>();
			for(int j=0;j<tagsNum;j++){
				int tagsCatagory = random.nextInt()%10;
				if(tagsCatagory<0) tagsCatagory*=-1;
				list.add(departmentTags[tagsCatagory]);
			}
			for(int p=0;p<list.size()-1;p++){
			    for(int j=list.size()-1;j>p;j--){
			      if(list.get(j).equals(list.get(p))){
			        list.remove(j);
			      } 
			    } 
			 } 
			for(int k=0;k<timesNum;k++){
				int time = random.nextInt()%10;
				if(time<0) time*=-1;
				time+=9;
				int timesCatagory = random.nextInt()%7;
				if(timesCatagory<0) timesCatagory*=-1;
				list2.add(departmentTimes[timesCatagory]+"."+time+":00~"+(time+1)+":00");
			}
			departmentsBean.setTags(list);
			departmentsBean.setEvent_schedules(list2);
			departmentsBeans.add(departmentsBean);
		}
		for(int i=0;i<300;i++){
			StudentsBean studentsBean = new StudentsBean();
			studentsBean.setStudent_no("031502"+(i+100));
			int appCount = random.nextInt()%6;
			if(appCount<0) appCount*=-1;
			int timesNum = random.nextInt()%8;
			if(timesNum<0) timesNum*=-1;
			timesNum++;
			int tagsNum = random.nextInt()%4;
			if(tagsNum<0) tagsNum*=-1;
			tagsNum+=2;
			ArrayList<String> list1 = new ArrayList<>();
			ArrayList<String> list2 = new ArrayList<>();
			ArrayList<String> list3 = new ArrayList<>();
			for(int j=0;j<appCount;j++){
				int a = random.nextInt()%20;
				if(a<0) a*=-1;
				list1.add(departmentID[a]);
			}
			for(int p=0;p<list1.size()-1;p++){
			    for(int j=list1.size()-1;j>p;j--){
			      if(list1.get(j).equals(list1.get(p))){
			        list1.remove(j);
			      } 
			    } 
			 } 
			studentsBean.setApplications_department(list1);
			for(int k=0;k<timesNum;k++){
				int time = random.nextInt()%10;
				if(time<0) time*=-1;
				time+=9;
				int timesCatagory = random.nextInt()%7;
				if(timesCatagory<0) timesCatagory*=-1;
				list2.add(departmentTimes[timesCatagory]+"."+time+":00~"+(time+1)+":00");
			}
			for(int p=0;p<list2.size()-1;p++){
			    for(int j=list2.size()-1;j>p;j--){
			      if(list2.get(j).equals(list2.get(p))){
			        list2.remove(j);
			      } 
			    } 
			 } 
			studentsBean.setFree_time(list2);
			for(int p=0;p<tagsNum;p++){
				int tagsCatagory = random.nextInt()%10;
				if(tagsCatagory<0) tagsCatagory*=-1;
				list3.add(departmentTags[tagsCatagory]);
			}
			for(int p=0;p<list3.size()-1;p++){
			    for(int j=list3.size()-1;j>p;j--){
			      if(list3.get(j).equals(list3.get(p))){
			        list3.remove(j);
			      } 
			    } 
			 } 
			studentsBean.setTags(list3);
			studentsBeans.add(studentsBean);
		}
		inputBean.setDepartments(departmentsBeans);
		inputBean.setStudents(studentsBeans);
	}
	
	public InputBean getInputBean() {
		return inputBean;
	}

	public void setInputBean(InputBean inputBean) {
		this.inputBean = inputBean;
	}
	
}
