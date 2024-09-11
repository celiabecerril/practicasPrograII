package PyHorario;

public class Schedule {

    private Subject[][] subjects;

    public Schedule () {
        //subjects es una referencia  a una matriz de referencia
        subjects = new Subject[5][8];
    
    }


    public void addSubject(Subject subject, int day, int hour) {
        this.subjects[day][hour] = subject;

    }

    public void exchange (int firstDay, int firstHour, int secondDay, int secondHour) {

    }

    public String show() {
        
        String schedule = "";
        for (int hour = 0; hour < 8; hour++) {
            for (int day = 0; day < 5; day++) {
                if (subjects[day][hour] != null) {
                    schedule += subjects[day][hour].showCode() + "\n";
                }
                else {
                    schedule = schedule + "----";
                
                }
            }
            schedule =schedule + "\n";
        }
        return schedule;
    }

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        System.out.println(schedule.show());
        Subject subject = new Subject("Programacion I");
        schedule.addSubject(subject, 1, 1);
        System.out.println(schedule.show());
    }
}
