import java.util.ArrayList;
import java.util.List;

public interface StudentManagement {
    void addStudent();
    void updateStudent(String name,String newEmail, int newNumber);//changer
    public List<Student> seeStudent();
    List<Matiere> getSubjectsForStudent(String name);
    void afficherStudent();
    void deleteStudent(String name);
    double calculerMoyenNoteMatier(String name, String matiereName);
    double calculerMoyenGeneral(String name);
}
