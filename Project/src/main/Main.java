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
		//DataMakerΪ�Զ�����input_data����
		DataMaker dataMaker = new DataMaker();
		dataMaker.setData();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String input_data = gson.toJson(dataMaker.getInputBean());
		//����Զ����ɵ�input_data.txt
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
		//ɾ�����µ�ע�ͺ�ɾ��ǰ���Match match = new Match();�������������ڴ��뼴�ɶ�ȡ��ǰĿ¼��input_data.txt�����
		//String input_data = match.getInputString("input_data.txt");
		match.initData(input_data);//��ʼ������
		match.sortDepartment(match.getDepartments(), 0, match.getDepartments().size()-1);//�Բ�������
		match.countStudentScore();//ͳ��ѧ�����ȼ�
		match.match_DtoS();//ƥ��
		match.getOutputTxt();//������
		System.out.println("Admitted Students Total Number (1 student may join 2 departments.): "+match.getAdmittedStudentsNumber());
		System.out.println("Unlacky_student_num : "+match.getBean2().getUnlucky_student().size());
		System.out.println("Unlacky_department_num : "+match.getBean2().getUnlucky_department().size());
	}
	
}
