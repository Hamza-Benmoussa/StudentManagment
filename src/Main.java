
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ManagmentStudent managmentStudent = new ManagmentStudent();

        manage:
        while (true){
            int p ;
            Scanner scanner =new Scanner(System.in);
            System.out.println("\nOptions:");
            System.out.println("1. Add Student with all information");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. SeeAllStudent");
            System.out.println("5. Calcul Averge 1 / 2 ");
            System.out.println("6. Exit");

            p=scanner.nextInt();
            switch (p){
                case 1:
                    // Utilisez la nouvelle méthode addStudent
                    managmentStudent.addStudent();
                    managmentStudent.afficherStudent();
                    break;

                case 2 :
                    System.out.println("Enter the name : ");
                    String nn=scanner.next();
                    managmentStudent.deleteStudent(nn);
                    managmentStudent.afficherStudent();
                    break;

                case 3:
                    System.out.println("Enter the name : ");
                    String nameStudent = scanner.next();
                    System.out.println("Enter newEmail: ");
                    String newEmail = scanner.next();
                    System.out.println("Enter newNumber: ");
                    int newNumber = scanner.nextInt();

                    managmentStudent.updateStudent(nameStudent,newEmail,newNumber);
                    managmentStudent.afficherStudent();
                    break;
                case 4:

                    //Function for seeAllStudent

                    List<Student> listStudent = managmentStudent.seeStudent();
                    for (Student student1: listStudent){
                        System.out.println(student1);
                    }
                    break ;

                case 5:
                    System.out.println("Enter name student : ");
                    String studentName = scanner.next();
                    List<Matiere> labelMat = managmentStudent.getSubjectsForStudent(studentName);
                    if (!labelMat.isEmpty()) {
                        for (Matiere matiere:labelMat){
                            System.out.println("Subject " + studentName + " : " + matiere.getLabelMatier());
                        }

                        //give him choise 1 to calculate the the moyen of one subject or all and choise 2 calculate moyen of all subject

                        System.out.println("Choose option 1 to calculate the average grade for a specific subject, or option 2 to calculate the overall average across all subjects: ");
                        System.out.println("Enter your choice : ");
                        int optionForCalcul = scanner.nextInt();
                        switch (optionForCalcul){
                            case 1 :
                                System.out.println("Enter subject : ");
                                String matiereChoix = scanner.next();
                                double resultat = managmentStudent.calculerMoyenNoteMatier(studentName,matiereChoix);
                                System.out.println("The average grade for " + matiereChoix + " is: " + resultat);
                                break ;
                            case 2:
                                System.out.println("Enter name student : ");
                                String sudentName = scanner.next();
                                double resultAll = managmentStudent.calculerMoyenGeneral(sudentName);
                                if (resultAll != -1) {
                                    System.out.println("Here is the overall average grade across all subjects: " + resultAll);
                                } else {
                                    System.out.println("Student does not exist with the name: " + studentName);
                                }
                                break;
                            default:
                                System.out.println("Invalid choice. Please enter a valid option.");
                        }
                    } else {
                        System.out.println("Student does not exist with the name: " + studentName);
                    }

                    break;
                case 6:
                    break manage;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

    }
}