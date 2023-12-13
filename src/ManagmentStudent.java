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
    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null; // Si l'étudiant n'est pas trouvé
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
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name: ");
        String name = scanner.next();

        // Vérifier si l'étudiant existe déjà
        boolean studentExists = checkStudent(name);

        if (studentExists) {
            System.out.println("Student already exists. Adding subjects and grades.");

            // Obtenir l'étudiant existant
            Student existingStudent = getStudentByName(name);

            // Code pour ajouter des matières et des notes à l'étudiant existant
            System.out.println("How many subjects: ");
            int mat = scanner.nextInt();
            for (int i = 0; i < mat; i++) {
                System.out.println("Enter the subject name: ");
                String subjectName = scanner.next();
                System.out.println("How many grades for this subject: ");
                int noteCount = scanner.nextInt();

                List<Integer> noteSubject = new ArrayList<>();
                for (int j = 0; j < noteCount; j++) {
                    System.out.println("Enter the grade value: ");
                    int noteVal = scanner.nextInt();
                    if (noteVal >= 0 && noteVal <= 20) {
                        noteSubject.add(noteVal);
                    } else {
                        System.out.println("Invalid grade value. Enter a value between 0 and 20!");
                        j--;
                    }
                }

                // Ajouter le sujet avec les notes à l'étudiant existant
                Matiere matiere = new Matiere(subjectName, noteSubject);
                existingStudent.getMatiere().add(matiere);
            }

            System.out.println("Subjects and grades have been added for the existing student.");
        } else {
            // L'étudiant n'existe pas, ajouter un nouvel étudiant avec des matières et des notes
            System.out.println("Student does not exist. Adding a new student with subjects and grades.");

            System.out.println("Enter the email: ");
            String email = scanner.next();

            System.out.println("Enter the phone number: ");
            int phoneNumber = scanner.nextInt();

            System.out.println("How many subjects: ");
            int mat = scanner.nextInt();
            List<Matiere> matieres = new ArrayList<>();

            // Boucle pour le nombre de matières
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

            // Ajouter le nouvel étudiant avec les matières
            Student student = new Student(name, email, phoneNumber, matieres);
            students.add(student);
            System.out.println("New student has been added with subjects and grades.");
        }
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
        // If the student or subject is not found, return -1 for indicate an error
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
        // If the student or subjects are not found or there are no grades, return -1 for indicate an error
        return -1;
    }

}