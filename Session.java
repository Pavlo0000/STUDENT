package University;

import java.util.List;
import java.util.ArrayList;

public class Session {
    private List<Discipline> disciplines;

    public Session(){
        this.disciplines = new ArrayList<>();
    }

    public Session(Discipline discipline){
        this.disciplines = new ArrayList<>();
        disciplines.add(discipline);
    }

    public Session(ArrayList<Discipline> disciplines){
        this.disciplines = disciplines;
    }

    public Session(String name){
        this.disciplines.add(new Discipline(name));
    }

    public void setDiscipline(Discipline discipline){
        this.disciplines.add(discipline);
    }

    public void setDiscipline(String name){
        this.disciplines.add(new Discipline(name));
    }

    public void setDiscipline(ArrayList<Discipline> disciplines){
        this.disciplines.addAll(disciplines);
    }

    public void setGrade(Grades grade, int counter){
        this.disciplines.get(counter).setGrade(grade);
    }

    public int getLength(){
        return disciplines.size();
    }

    public String toString(){
        StringBuilder message = new StringBuilder();
        for(Discipline d: disciplines){
            message.append(d + "\n");
        }
        return message.toString();
    }
}
