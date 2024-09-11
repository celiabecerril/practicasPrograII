package PyHorario;

public class Subject {

    private String name;
    private String code;
    private int credits;


    public Subject(String name, String code, int credits) {
        this.name = name;
        this.code = code;
        this.credits = credits;
    }

    public Subject (String name) {
        this(name, name.substring(0,4).toUpperCase(), 0);
    }


    public Subject (Subject subject) {

        this(subject.name, subject.code, subject.credits);
    }
    public String show() {
        return "Subject{" + "name=" + name + ", code=" + code + ", credits=" + credits + '}';
    }

    public String showCode() {
        return code;
    }

    public void changeName(String name) {
        this.name = name;

    }

    public void changeCode(String code) {
        this.code = code;

    }

    public void changeCredits(int credits) {
        this.credits = credits;

    }

    public static void main(String[] args) {

        Subject subject = new Subject("Programacion I", "PRG1", 6);
        System.out.println(subject.show());
        Subject subject1= new Subject("Programacion II", "PRG2", 6);
        System.out.println(subject1.show());
        Subject subject2= new Subject("Bases de Datos II", "BBDDI", 6);
        System.out.println(subject2.showCode());
        Subject logic = new Subject ("Logica");
        Subject mate1 = new Subject("Mate1", "M1", 4);
        System.out.println(mate1.show());
        logic.changeCredits(4);
        System.out.println(logic.show());
        System.out.println(subject.show() + " - " + subject.showCode());
        System.out.println(mate1.show()); 
        
        
    }
    
}
