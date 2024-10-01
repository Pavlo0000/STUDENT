package University;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum StudentStatus{
    IS_STUDYING,
    STUDYING_IS_COMPLETE,
    EXPELLED
}

public class Student {
    private String fullname;
    private int age;
    private String faculty;
    private String speciality;
    private int course;
    private int semester;
    private final int year_of_admission;
    private List<Session> last_grades;
    private Session now_session;
    private int max_semesters;
    StudentStatus status;

    public Student(String fullname, int age, String faculty, String speciality, int max_semesters){
        this.fullname = fullname;
        this.age = age;
        this.faculty = faculty;
        this.speciality = speciality;
        this.course = 1;
        this.semester = 1;
        Date date = new Date();
        this.year_of_admission = date.getYear() + 1900;
        this.last_grades = new ArrayList<>();
        this.now_session = new Session();
        this.max_semesters = max_semesters;
        this.status = StudentStatus.IS_STUDYING;
    }

    public Student(String fullname, int age, String faculty, String speciality, int course, int semester, int max_semesters, List<Session> grades){
        this.fullname = fullname;
        this.age = age;
        this.faculty = faculty;
        this.speciality = speciality;
        Date date = new Date();
        this.year_of_admission = date.getYear() + 1900;
        this.last_grades = grades;
        this.course = course;
        this.semester = semester;
        this.max_semesters = max_semesters;
        this.status = StudentStatus.IS_STUDYING;
    }

    public void deduct(){
        this.status = StudentStatus.EXPELLED;
    }

    public void addAge(){
        if(this.status != StudentStatus.EXPELLED)
            this.age++;
    }

    public void changeFullname(String fullname){
        if(this.status != StudentStatus.EXPELLED)
            this.fullname = fullname;
    }

    public StudentStatus getStatus(){
        return this.status;
    }

    public String getFullname(){
        return this.fullname;
    }

    public String getInfo(){
        String info = "STATUS: " + status +  ", FULLNAME: " + fullname + ", AGE: " + age + "\nFACULTY: "
                + faculty + ", SPECIALITY: " + speciality + ", COURSE: "  + course + ", SEMESTER: " + semester;
        return info;
    }

    public String getFullInfo(){
        String fullinfo = "STATUS: " + status +  ", FULLNAME: " + fullname + ", AGE: " + age + "\nFACULTY: "
                + faculty + ", SPECIALITY: " + speciality + ", COURSE: "  + course + ", SEMESTER: " + semester
                + "\n";
        fullinfo += "LAST GRADES:\n";
        for(int i = 0; i < last_grades.size(); i++){
            fullinfo += (i + 1) + " SESSION:\n" + last_grades.get(i).toString();
        }
        return fullinfo;
    }

    public void nextSemester(Session newSession){
        if(this.status != StudentStatus.EXPELLED){
            if(this.semester == this.max_semesters){
                last_grades.add(now_session);
                this.status = StudentStatus.STUDYING_IS_COMPLETE;
            }
            else {
                this.semester++;
                if (this.semester % 2 == 1)
                    course++;
                this.last_grades.add(this.now_session);
                this.now_session = newSession;
            }
        }
    }

    public void setNow_session(Session s){
        this.now_session = s;
    }

    public int getCountNowSessionDisciplines(){
        return now_session.getLength();
    }

    public void setGrades(int count, Grades grade){
        if(this.status != StudentStatus.EXPELLED)
            this.now_session.setGrade(grade, count);
    }

    public String toString(){
        return "STATUS: " + status +  ", FULLNAME: " + fullname + ", AGE: " + age + "\nFACULTY: "
                + faculty + ", SPECIALITY: " + speciality + ", COURSE: "  + course + ", SEMESTER: " + semester;
    }
}
