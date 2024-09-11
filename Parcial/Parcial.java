package Parcial;

class Parcial {

    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Manuel Masias", "666999XY");
        Subject subject1 = new Subject("Programacion 2", "PRG2", 6);
        teacher1.addSubject(subject1);
        Teacher teacher2 = new Teacher("Loyda Alas", "433452A");
        Exam exam1 = new Exam("Examen Parcial", teacher2);
        Question question1 = new Question("Vista pública de una clase");
        Question question2 = new Question("Vista pública de objetos");
        Question question3 = new Question("Vista privada de clases");
        exam1.addQuestion(question1);
        exam1.addQuestion(question2);
        exam1.addQuestion(question3);

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

        System.out.println("Subject: " + name + " Code: " + code + " Credits: " + credits);
    }

    public void deteleSubject() {
        name = null;
        code = null;
        credits = 0;

    }
}

class Teacher {

    private String name;
    private String id;
    private Subject[] subjects;
    private int numSubjects;

    public Teacher(String name, String id) {
        this.name = name;
        this.id = id;
        this.subjects = new Subject[3];
        this.numSubjects = 0;

    }

    public void addSubject(Subject subject) {
        if (numSubjects < subjects.length) {
            subjects[numSubjects] = subject;
            numSubjects++;
            System.out.println("Nombre del profesor: " + name + "-" + "NIE: " + id);
            System.out.println("Asignatura: Programacion 2 - PRG2 - 6 créditos");
            System.out.println("Examen: Examen Parcial / Vigilado por Profª: Loyda Alas - DNI 433452A"); 
        } else {
            System.out.println("No se pueden agregar más asignaturas.");
        }
    }

    public Boolean isNie(String id) {
        if (id.length() == 9) {
            return true;
        } else {
            return false;
        }

    }

    public void showInfo() {
        System.out.println("Teacher Name: " + name + ", ID: " + id);

    }

}

class Question {

    private String name;

    public Question(String name) {
        this.name = name;
    }

    public String editQuestion(String name) {
        return name;
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
        this.questions = new Question[3];
        this.numQuestions = 0;

    }
    

    

    public void addQuestion(Question question) {
       
        if (numQuestions < questions.length) {
            String questionText;
            
            switch (numQuestions) {
                case 0:
                    questionText = "Vista pública de clases";
                    break;
                case 1:
                    questionText = "Vista pública de objetos";
                    break;
                case 2:
                    questionText = "Vista privada de clases";
                    break;
                default:
                    return;
            }
            questions[numQuestions] = question;
            numQuestions++;
            System.out.println("Pregunta " + numQuestions + ": " + questionText);
        } else {
            System.out.println("No se pueden agregar más preguntas.");
        }
    }

    public void deleteQuestion(Question question) {
        for (int i = 0; i < numQuestions; i++) {
            if (questions[i].equals(question)) {

                for (int j = i; j < numQuestions - 1; j++) {
                    questions[j] = questions[j + 1];
                }
                questions[numQuestions - 1] = null;
                numQuestions--;
                break;
            }
        }
    }

}


