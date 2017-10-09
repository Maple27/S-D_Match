package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import bean.InputBean;
import bean.OutputBean;
import bean.OutputBean.AdmittedBean;
import entity.Department;
import entity.Student;

public class Match {

	private ArrayList<Student> students;
	private ArrayList<Department> departments;
	private InputBean bean;
	private OutputBean bean2;

	//读取输入txt文件
	public String getInputString(String path){
		StringBuffer sb = new StringBuffer();
		String content = null;
		File file = new File(path);
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file) , "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null)
				sb.append(line);
			content = sb.toString();
			bufferedReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
	
	//写入输出txt文件
	public void getOutputTxt(){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		OutputBean outputBean = new OutputBean();
		for(int i=0;i<students.size();i++){
			if(students.get(i).getFlag()==0){
				outputBean.getUnlucky_student().add(students.get(i).getId());
			}
		}
		for(int j=0;j<departments.size();j++){
			if(departments.get(j).getNum()==0){
				outputBean.getUnlucky_department().add(departments.get(j).getId());
			}else{
				AdmittedBean admittedBean = new AdmittedBean();
				for(int k=0;k<departments.get(j).getMembers().size();k++){
					admittedBean.getMember().add(departments.get(j).getMembers().get(k).getId());
				}
				admittedBean.setDepartment_no(departments.get(j).getId());
				outputBean.getAdmitted().add(admittedBean);
			}
		}
		this.bean2 = outputBean;
		String output_data = gson.toJson(outputBean);
		File file = new File("output_data.txt"); 
        try {
			file.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(file));  
	        out.write(output_data);
	        out.flush();
	        out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//初始化数据
	public void initData(String data){
		Gson gson = new Gson();
		Type type = new TypeToken<InputBean>(){}.getType();
		this.bean = gson.fromJson(data, type);
		students = new ArrayList<>();
		departments = new ArrayList<>();
		for(int i=0;i<bean.getStudents().size();i++){
			Student student = new Student(bean.getStudents().get(i).getStudent_no()
					, bean.getStudents().get(i).getFree_time(), bean.getStudents().get(i).getTags()
					, bean.getStudents().get(i).getApplications_department(), new ArrayList<>());
			students.add(student);
		}
		for(int i=0;i<bean.getDepartments().size();i++){
			Department department = new Department(bean.getDepartments().get(i).getDepartment_no()
					, bean.getDepartments().get(i).getMember_limit(), bean.getDepartments().get(i).getTags()
					, bean.getDepartments().get(i).getEvent_schedules(), new ArrayList<>());
			departments.add(department);
		}
	}
	
	//根据学生分数从小到大排序
	public void sortStudent(List<Student> list, int low, int hight,int p) {
        int i, j;
        Student index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = list.get(i);
        while (i < j) {
            while (i < j && list.get(j).getScores().get(p) >= index.getScores().get(p))
                j--;
            if (i < j){
            	list.set(i++, list.get(j));
            }
            	
            while (i < j && list.get(i).getScores().get(p) < index.getScores().get(p))
                i++;
            if (i < j)
                list.set(j--, list.get(i));
        }
        list.set(i, index);
        sortStudent(list, low, i - 1, p);
        sortStudent(list, i + 1, hight, p);

    }
	
	//根据部门tags数量从小到大排序
	public void sortDepartment(List<Department> list, int low, int hight) {
        int i, j;
        Department index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = list.get(i);
        while (i < j) {
            while (i < j && list.get(j).getTagsSize() >= index.getTagsSize())
                j--;
            if (i < j){
            	list.set(i++, list.get(j));
            }
            	
            while (i < j && list.get(i).getTagsSize() < index.getTagsSize())
                i++;
            if (i < j)
                list.set(j--, list.get(i));
        }
        list.set(i, index);
        sortDepartment(list, low, i - 1);
        sortDepartment(list, i + 1, hight);
    }
	
	//统计学生在各部门的分数
	public void countStudentScore(){
		for(int i=0;i<departments.size();i++){
			for(int j=0;j<students.size();j++){
				List<String> dTimes = departments.get(i).getActivityTime();
				List<String> sTimes = students.get(j).getFreeTime();
				List<String> dTags = departments.get(i).getTags();
				List<String> sTags = students.get(j).getInterests();
				int score = 0;
				//时间分数统计
				for(int m=0;m<dTimes.size();m++){
					String str1 = dTimes.get(m);
					String[] string2 = str1.split("\\.");
					String[] string3 = string2[1].split("~");
					String[] string4 = string3[0].split(":");
					String[] string5 = string3[1].split(":");
					String day1 = string2[0];
					int start1 = Integer.parseInt(string4[0]);
					int end1 = Integer.parseInt(string5[0]);
					for(int n=0;n<sTimes.size();n++){
						String str2 = sTimes.get(n);
						String[] string6 = str2.split("\\.");
						String[] string7 = string6[1].split("~");
						String[] string8 = string7[0].split(":");
						String[] string9 = string7[1].split(":");
						String day2 = string6[0];
						int start2 = Integer.parseInt(string8[0]);
						int end2 = Integer.parseInt(string9[0]);
						
						if(day1.equals(day2)){
							if(end1<=start2||end2<start1){
								score += 0;
							}
							else if(start1<start2&&end1>start2&&end1<end2){
								score += end1-start2;
							}
							else if(start2<start1&&end2>start1&&end2<end1){
								score += end2-start1;
							}
							else if(start1>start2&&end1<end2){
								score += end1-start1;
							}
							else if(start2>start1&&end2<end1){
								score += end2-start2;
							}
						}
					}
				}
				//兴趣分数统计
				for(int p=0;p<dTags.size();p++){
					String tag1 = dTags.get(p);
					for(int q=0;q<sTags.size();q++){
						String tag2 = sTags.get(q);
						if(tag1.equals(tag2)){
							score += 2;
						}
					}
				}
				//将此部门与学生时间匹配的分数加入学生信息中
				students.get(j).getScores().add(score);
			}
		}
	}
	
	//部门编号选学生志愿匹配算法
	public void match_DtoS(){
		for(int i=0;i<departments.size();i++){//部门匹配
			int num = 0,flag = 0;
			//每次对一个部门招募时以学生对此部门的分数对学生进行重新排列
			sortStudent(students, 0, students.size()-1, i);
			for(int j=0;j<5;j++){//志愿匹配
				for(int k=0;k<students.size();k++){//学生匹配
					//超限 下一个
					if(num>=departments.get(i).getLimit()){
						flag=1;
						break;
					}
					//志愿不足 下一个
					if(students.get(k).getWillsSize()<=j) continue;
					String wills = students.get(k).getWills().get(j);
					String no = departments.get(i).getId();
					if(wills.equals(no)){
						//符合志愿条件，根据符合分数进行分配
						departments.get(i).getMembers().add(students.get(k));
						students.get(k).setFlag(1);
						num++;
					}
				}
				if(flag==1) break;
			}
			departments.get(i).setNum(num);
		}
		for(int i=0;i<departments.size();i++){
			for(int p=0;p<departments.get(i).getMembers().size()-1;p++){
			    for(int j=departments.get(i).getMembers().size()-1;j>p;j--){
			      if(departments.get(i).getMembers().get(j).equals(departments.get(i).getMembers().get(p))){
			    	  departments.get(i).getMembers().remove(j);
			      } 
			    } 
			}
	
		} 
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(ArrayList<Department> departments) {
		this.departments = departments;
	}

	public InputBean getBean() {
		return bean;
	}

	public void setBean(InputBean bean) {
		this.bean = bean;
	}
	
	public OutputBean getBean2() {
		return bean2;
	}

	public void setBean2(OutputBean bean2) {
		this.bean2 = bean2;
	}
	
	public int getAdmittedStudentsNumber(){
		int num = 0;
		for(int i=0;i<bean2.getAdmitted().size();i++){
			num+=bean2.getAdmitted().get(i).getMember().size();
		}
		return num;
	}
	
}
