package University;

;

public class Discipline {
    private String name;
    private Grades grade;

    public Discipline(String name){
        this.name = name;
        this.grade = Grades.NOT_DEFINED;
    }

    public Grades getGrade(){
        return grade;
    }

    public void setGrade(Grades grade){
        this.grade = grade;
    }

    public String toString(){
        return name + " - " + grade;
    }
}


