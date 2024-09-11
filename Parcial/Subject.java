package Parcial;
class Teacher {
    private String name;
    private String id;

    public Teacher(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void addSubject(Subject subject) {
        subject.showInfo();
    }
    public boolean isNie(String id) {
        return id.length() == 9;
    
    }

    public void showInfo() {
        System.out.println("Teacher Name: " + this.name + ", ID: " + this.id);
    }

    
}

class Subject {
    private String name;
    private String code;
    private int credits;

    public Subject(String name, String code, int credits) {
        this.name = name;
        this.code = code;
        this.credits = credits;
    }

    public void showInfo() {
        System.out.println("Subject Name: " + this.name + ", Code: " + this.code + ", Credits: " + this.credits);
    }

    public void deleteSubject() {
        this.name = "";
        this.code = "";
        this.credits = 0;
    }
}

class Question {
    private String name;

    public Question(String name) {
        this.name = name;
    }

    public void showInfo() {
        System.out.println("Question: " + this.name);
    }
}

class Exam {
    private String name;
    private Teacher teacher;
    private Question[] questions;
    private int numQuestions;

    public Exam(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        this.questions = new Question[10];  // Asumiendo que un examen puede tener hasta 10 preguntas
        this.numQuestions = 0;
    }

    public void addQuestion(Question question) {
        if (this.numQuestions < this.questions.length) {
            this.questions[this.numQuestions] = question;
            this.numQuestions++;
        } else {
            System.out.println("No se pueden agregar más preguntas.");
        }
    }

    public void showInfo() {
        System.out.println("Exam Name: " + this.name);
        teacher.showInfo();
        for (int i = 0; i < numQuestions; i++) {
            questions[i].showInfo();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Manuel Masias", "666999XY");
        Subject subject1 = new Subject("Programacion 2", "PRG2", 6);
        teacher1.addSubject(subject1);
        Teacher teacher2 = new Teacher("Loyda Alas", "433452A");
        Exam exam1 = new Exam("Examen Parcial", teacher2);
        Question question1 = new Question("Vista pública de una clase");
        Question question2 = new Question("Vista pública de objetos");
        Question question3 = new Question("Vista privada");
        exam1.addQuestion(question1);
        exam1.addQuestion(question2);
        exam1.addQuestion(question3);
        exam1.showInfo();
    }
}