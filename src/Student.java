import java.util.List;

public class Student {
    private String name;
    private String email;
    private int number;
    private List<Matiere> matiere ;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student(String name, String email, int number, List<Matiere> matiere) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.matiere = matiere;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<Matiere> getMatiere() {

        return matiere;
    }

    public void setMatiere(List<Matiere> matiere) {

        this.matiere = matiere;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number=" + number +
                ", matiere=" + matiere +
                '}';
    }
}
