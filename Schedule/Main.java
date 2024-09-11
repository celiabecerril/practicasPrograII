package Schedule;

class Schedule {

    private Subject[][] subjects;

    public Schedule() {
        this.subjects = new Subject[5][6];
    }

    public void addSubject(Subject subject, int day, int hour) {
        if (day >= 0 && day < 5 && hour >= 0 && hour < 6) {
            this.subjects[day][hour] = subject;
        } else {
            System.out.println("No se puede agregar la asignatura en ese horario.");
        }
    }

    public void switchSubject(Subject newSubject, int day, int hour) {
        if (day >= 0 && day < 5 && hour >= 0 && hour < 6) {
            this.subjects[day][hour] = newSubject;
        } else {
            System.out.println("No se puede cambiar la asignatura en ese horario.");
        }
    }

    public void showSchedule() {
        System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s%n", "Hora\\Día", "Lunes", "Martes", "Miércoles", "Jueves",
                "Viernes");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%-10s", "Hora " + (i + 1));
            for (int j = 0; j < 5; j++) {
                if (this.subjects[j][i] != null) {
                    System.out.printf("%-15s", this.subjects[j][i].getName());
                } else {
                    System.out.printf("%-15s", "Libre");
                }
            }
            System.out.println();
        }
    }

}

class Subject {

    private String name;
    private int credits;
    private int code;

    public Subject(String name, int credits, int code) {
        assert name != null && credits >= 0 && code >= 0;
        this.name = name;
        this.credits = credits;
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void showSubject() {
        System.out.println("Nombre: " + this.name + " Créditos: " + this.credits + " Código: " + this.code);
    }

}

class Main {
    public static void main(String[] args) {
        Subject maths = new Subject("Matematicas", 6, 1);
        maths.showSubject();

        Subject prog = new Subject("Programacion", 4, 2);
        prog.showSubject();

        Subject databases = new Subject("Base de Datos", 5, 3);
        databases.showSubject();

        Schedule schedule = new Schedule();
        schedule.addSubject(maths, 1, 2);
        schedule.addSubject(prog, 2, 3);
        schedule.addSubject(databases, 3, 1);
        schedule.switchSubject(databases, 1, 2);
        schedule.showSchedule();
    }
}
