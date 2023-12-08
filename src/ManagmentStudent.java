import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagmentStudent implements StudentManagement{
    public List<Student> students;
    Scanner scanner = new Scanner(System.in);

    public ManagmentStudent (){

        this.students = new ArrayList<>();
    }
    public List<Student> seeStudent(){
        return students;
    }
    public Boolean checkStudent(String name){
        for (Student student : students){
            if (student.getName().equals(name)){
                return true;
            }

        }
        return false;
    }


    @Override
    public Student addStudent(Student student) {
        for (Student existStudent : students) {
            if (existStudent.getName().equals(student.getName())) {
                System.out.println("The student with the name '" + student.getName() + "' already exists.");

                // Display existing subjects and grades
                System.out.println("Existing subjects and grades:");
                List<Matiere> existingSubjects = existStudent.getMatiere();
                for (Matiere existingMatiere : existingSubjects) {
                    System.out.println(existingMatiere.getLabelMatier() + ": " + existingMatiere.getNote());
                }

                System.out.println("Do you want to add new subjects? Enter 1 for Yes, 0 for No: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                if (choice == 1) {
                    // Add new subjects and grades
                    System.out.println("How many subjects: ");
                    int mat = scanner.nextInt();
                    List<Matiere> matieres = new ArrayList<>();
                    for (int i = 0; i < mat; i++) {
                        System.out.println("Enter the subject name: ");
                        String subjectName = scanner.next();
                        System.out.println("How many grades for this subject: ");
                        int note = scanner.nextInt();
                        List<Integer> noteSubject = new ArrayList<>();
                        for (int j = 0; j < note; j++) {
                            System.out.println("Enter the grade value: ");
                            int noteVal = scanner.nextInt();
                            if (noteVal >= 0 && noteVal <= 20) {
                                noteSubject.add(noteVal);
                            } else {
                                System.out.println("Invalid grade value. Enter a value between 0 and 20!");
                                j--;
                            }
                        }
                        Matiere matiere = new Matiere(subjectName, noteSubject);
                        matieres.add(matiere);
                    }
                    existStudent.getMatiere().addAll(matieres);
                    System.out.println("New subjects and grades have been added for the existing student.");
                }

                return existStudent; // Return existing student with or without new subjects and grades
            }
        }

        students.add(student);
        System.out.println("Student has been added: " + student.getName());
        return student;
    }



    @Override
    public void updateStudent(String name,String newEmail,int newNumber){
        for (Student student: students){
            if (student.getName().equals(name)){
                student.setEmail(newEmail);
                student.setNumber(newNumber);
                System.out.println("Student has been successfully modified: " + name);
                return;
            }
        }
        System.out.println("No student found with the name: " + name);
    }

//    @Override
//    public ArrayList<Student> searchStudent(String name)
//    {
//        ArrayList<Student> list = new ArrayList<>();
//        for (Student student : students){
//            if (student.getName().equals(name)){
//                list.add(student);
//            }
//        }
//        return list;
//
//    }

    @Override
    public void afficherStudent() {
        for (Student student: students){
            System.out.println("Here is the student information: " + student);
        }
    }

    @Override
    public void deleteStudent(String name) {
        for (Student student: students){
            if (student.getName().equals(name)) {
                students.remove(student);
                System.out.println("The student '" + name + "' has been deleted.");
                return;
            }
        }
        System.out.println("No student found with the name: " + name);
    }
    //function return list subject and we need to pass the name
    public List<Matiere> getSubjectsForStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student.getMatiere();
            }
        }
        // return emmptY list
        return new ArrayList<>();
    }
    //function for calculer averge subject

    @Override
    public double calculerMoyenNoteMatier(String name, String matiereName) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                List<Matiere> matieres = student.getMatiere();
                for (Matiere matiere : matieres) {
                    if (matiere.getLabelMatier().equals(matiereName)) {
                        List<Integer> notes = matiere.getNote();
                        if (!notes.isEmpty()) {
                            double sum = 0;
                            for (int note : notes) {
                                sum += note;
                            }
                            return sum / notes.size();
                        }
                    }
                }
            }
        }
        // If the student or subject is not found, return -1 to indicate an error
        return -1;
    }
    //function for calculer averge all subject

    @Override
    public double calculerMoyenGeneral(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                List<Matiere> matieres = student.getMatiere();
                if (!matieres.isEmpty()) {
                    double sum = 0;
                    int totalNotes = 0;
                    for (Matiere matiere : matieres) {
                        List<Integer> notes = matiere.getNote();
                        for (int note : notes) {
                            sum += note;
                            totalNotes++;
                        }
                    }
                    if (totalNotes > 0) {
                        return sum / totalNotes;
                    }
                }
            }
        }
        // If the student or subjects are not found or there are no grades, return -1 to indicate an error
        return -1;
    }

}