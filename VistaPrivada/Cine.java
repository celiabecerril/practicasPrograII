package VistaPrivada;

public class Cine {

    public static void main(String[] args) {
        
        System.out.println("Welcome to the cinema");
        
        Movie movie1 = new Movie("Shrek", "Andrew Adamson"); 
        Movie movie2 = new Movie("The Lord of the Rings", "Peter Jackson");
        
        Viewer viewer1 = new Viewer("Celia", 3);
        Viewer viewer2 = new Viewer("Laura", 30);
        
        viewer1.watchMovie(movie1);
        viewer2.watchMovie(movie2);

        Ticket ticket1 = new Ticket(viewer1,5);
        ticket1.buyTicket();
        Ticket ticket2 = new Ticket(viewer2, 5);
        ticket2.buyTicket();
    }
    
}

class Movie {
    
    private String title;
    private String director;
    
    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }
    
    public void showInfo() {
        System.out.println("Title: " + title);
        System.out.println("Director: " + director);
    }
    
}

class Viewer {


    private String name;
    private int age;
    private Movie watchedMovie;
    
    public Viewer(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void watchMovie(Movie movie) {
        watchedMovie = movie;
        System.out.println(name + " watched the movie:");
        watchedMovie.showInfo();
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }
    
    
}

class Ticket {
    private Viewer viewer;
    private int price;
    
    public Ticket(Viewer viewer,  int price) {
        this.viewer = viewer;
        
        this.price = price;
    }
    
   
    public void buyTicket() {
        double finalPrice = price;

        
        if (viewer.age() < 10) {
            finalPrice *= 0.5;
            System.out.println("A 50% discount has been applied because the viewer is under 10 years old.");
        }

        System.out.println(viewer.name() + " bought a ticket for the movie:");
        System.out.println("Price: " + finalPrice);
    }
    
}