package bean;

import java.util.List;

public class InputBean {

	private List<StudentsBean> students;
    private List<DepartmentsBean> departments;

    public List<StudentsBean> getStudents() {
        return students;
    }

    public void setStudents(List<StudentsBean> students) {
        this.students = students;
    }

    public List<DepartmentsBean> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentsBean> departments) {
        this.departments = departments;
    }

    public static class StudentsBean {

        private String student_no;
        private List<String> free_time;
        private List<String> applications_department;
        private List<String> tags;

        public String getStudent_no() {
            return student_no;
        }

        public void setStudent_no(String student_no) {
            this.student_no = student_no;
        }

        public List<String> getFree_time() {
            return free_time;
        }

        public void setFree_time(List<String> free_time) {
            this.free_time = free_time;
        }

        public List<String> getApplications_department() {
            return applications_department;
        }

        public void setApplications_department(List<String> applications_department) {
            this.applications_department = applications_department;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }

    public static class DepartmentsBean {
        /**
         * event_schedules : ["Mon.8:00~9:00","Thur.11:00~12:00"]
         * member_limit : 10
         * department_no : D001
         * tags : ["study","dance","chess","English"]
         */

        private int member_limit;
        private String department_no;
        private List<String> event_schedules;
        private List<String> tags;

        public int getMember_limit() {
            return member_limit;
        }

        public void setMember_limit(int member_limit) {
            this.member_limit = member_limit;
        }

        public String getDepartment_no() {
            return department_no;
        }

        public void setDepartment_no(String department_no) {
            this.department_no = department_no;
        }

        public List<String> getEvent_schedules() {
            return event_schedules;
        }

        public void setEvent_schedules(List<String> event_schedules) {
            this.event_schedules = event_schedules;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }
}

