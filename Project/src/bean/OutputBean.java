package bean;

import java.util.ArrayList;
import java.util.List;

public class OutputBean {
	
	private List<String> unlucky_student;
    private List<AdmittedBean> admitted;
    private List<String> unlucky_department;

    public OutputBean(){
    	unlucky_department = new ArrayList<>();
    	admitted = new ArrayList<>();
    	unlucky_student = new ArrayList<>();
    }
    
    public List<String> getUnlucky_student() {
        return unlucky_student;
    }

    public void setUnlucky_student(List<String> unlucky_student) {
        this.unlucky_student = unlucky_student;
    }

    public List<AdmittedBean> getAdmitted() {
        return admitted;
    }

    public void setAdmitted(List<AdmittedBean> admitted) {
        this.admitted = admitted;
    }

    public List<String> getUnlucky_department() {
        return unlucky_department;
    }

    public void setUnlucky_department(List<String> unlucky_department) {
        this.unlucky_department = unlucky_department;
    }

    public static class AdmittedBean {
        /**
         * member : ["031502191","031502167","031502222","031502208","031502087"]
         * department_no : D001
         */

        private String department_no;
        private List<String> member;

        public AdmittedBean(){
        	member = new ArrayList<>();
        }
        
        public String getDepartment_no() {
            return department_no;
        }

        public void setDepartment_no(String department_no) {
            this.department_no = department_no;
        }

        public List<String> getMember() {
            return member;
        }

        public void setMember(List<String> member) {
            this.member = member;
        }
    }
}
