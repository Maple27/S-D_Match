package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.MathContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bean.InputBean;
import bean.OutputBean;
import util.DataMaker;
import util.Match;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DataMaker为自动生成input_data的类
		DataMaker dataMaker = new DataMaker();
		dataMaker.setData();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String input_data = gson.toJson(dataMaker.getInputBean());
		//输出自动生成的input_data.txt
		File file = new File("input_data.txt");
        try {
        	file.createNewFile();
    		BufferedWriter out = new BufferedWriter(new FileWriter(file));  
			out.write(input_data);
			out.flush();
	        out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Match match = new Match();
		//删除底下的注释后并删除前面除Match match = new Match();的所有主函数内代码即可读取当前目录下input_data.txt并输出
		//String input_data = match.getInputString("input_data.txt");
		match.initData(input_data);//初始化数据
		match.sortDepartment(match.getDepartments(), 0, match.getDepartments().size()-1);//对部门排序
		match.countStudentScore();//统计学生优先级
		match.match_DtoS();//匹配
		match.getOutputTxt();//输出结果
		System.out.println("Admitted Students Total Number (1 student may join 2 departments.): "+match.getAdmittedStudentsNumber());
		System.out.println("Unlacky_student_num : "+match.getBean2().getUnlucky_student().size());
		System.out.println("Unlacky_department_num : "+match.getBean2().getUnlucky_department().size());
	}
	
}
