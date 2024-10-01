import University.Grades;
import University.Session;
import University.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MyC{
    public static void main(String[] args){
        Random rnd = new Random();

        List<String> firstN = new ArrayList<>();
        try{
            BufferedReader bF = new BufferedReader(new FileReader("C:\\Users\\PASHOK\\IdeaProjects\\MyProject\\src\\firstNames.txt"));
            String text;
            while((text = bF.readLine()) != null){
                firstN.add(text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> lastN = new ArrayList<>();
        try{
            BufferedReader bL = new BufferedReader(new FileReader("C:\\Users\\PASHOK\\IdeaProjects\\MyProject\\src\\lastNames.txt"));
            String text;
            while((text = bL.readLine()) != null){
                lastN.add(text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String faculty = "Faculty of Physics and Technology";
        String speciality = "Infocommunication technologies and communication systems";
        int[] ages = new int[]{18, 18, 17, 17, 17, 18, 18, 19, 20, 19, 18, 18, 18, 18, 18};
        Grades[] g = new Grades[]{Grades.FIVE, Grades.FIVE, Grades.FIVE, Grades.FOUR, Grades.FOUR,
                Grades.FOUR, Grades.FOUR, Grades.FOUR, Grades.FOUR, Grades.FOUR,
                Grades.FOUR, Grades.THREE, Grades.THREE, Grades.THREE, Grades.THREE, Grades.THREE,
                Grades.THREE, Grades.THREE, Grades.THREE, Grades.TWO, Grades.TWO, Grades.TWO};
        int max_semesters = 8;

        List<Student> students = new ArrayList<>();
        for(int i = 0; i < 30; i++){
            students.add(new Student(firstN.get(rnd.nextInt(firstN.size())) + " " + lastN.get(rnd.nextInt(lastN.size())),
                    ages[rnd.nextInt(ages.length)], faculty, speciality, max_semesters));
        }

        Session f = new Session();
        String[] disciplines = {"Math", "History", "Geometry", "Physics", "Programming"};
        for(String n: disciplines){
            f.setDiscipline(n);
        }

        for(Student s:students){
            s.setNow_session(f);
        }

        for(Student s:students){
            for(int i = 0; i < s.getCountNowSessionDisciplines(); i++){
                s.setGrades(i, g[rnd.nextInt(g.length)]);
            }
        }

        for(Student s:students){
            s.nextSemester(new Session());
            System.out.println(s.getFullInfo());
        }
    }
}