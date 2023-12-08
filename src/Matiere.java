import java.util.*;

public class Matiere {
    private String labelMatier;
    private List<Integer> note;
//    private static List<Matiere> matieres = new ArrayList<Matiere>();

    public Matiere(){

    }
    Scanner scanner = new Scanner(System.in);

    public Matiere(String labelMatier, List<Integer> note) {
        this.labelMatier = labelMatier;
        this.note = note;
    }
    //    public Matiere(String labelMatier , List<Integer> note) {
//        this.labelMatier = labelMatier;
//        matieres.add(this);
//        note = new ArrayList<>();
//    }

    public String getLabelMatier() {

        return labelMatier;
    }
    public void setLabelMatier(String labelMatier) {

        this.labelMatier = labelMatier;
    }

    public List<Integer> getNote() {

        return note;
    }

    public void setNote(List<Integer> note) {

        this.note = note;
    }

//    public static List<Matiere> getMatieres() {
//
//        return matieres;
//    }
//
//    public static void setMatieres(List<Matiere> matieres) {
//
//        Matiere.matieres = matieres;
//    }

    @Override
    public String toString() {
        return "Matiere{" +
                "labelMatier='" + labelMatier + '\'' +
                ", note=" + note +
                '}';
    }
    //    public void addMatier(){
//        System.out.println("ntre mat");
//        String nom = scanner.next();
//        Matiere m= new Matiere(nom);
//    }

}
