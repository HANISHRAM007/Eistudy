// Subsystem classes
class Amplifier {
    public void on() {
        System.out.println("Amplifier on.");
    }
    public void setVolume(int level) {
        System.out.println("Amplifier volume set to " + level);
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD Player on.");
    }
    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}

class Projector {
    public void on() {
        System.out.println("Projector on.");
    }
    public void setInput(String input) {
        System.out.println("Projector input set to " + input);
    }
}

class Lights {
    public void dim(int level) {
        System.out.println("Lights dimmed to " + level + "%.");
    }
}

// Facade class
class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;
    private Projector projector;
    private Lights lights;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector, Lights lights) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(10);
        amp.on();
        amp.setVolume(5);
        dvd.on();
        projector.on();
        projector.setInput("DVD");
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        lights.dim(100);
        amp.on();
        projector.on();
        dvd.on();
    }
}

// Client
public class FacadePatternDemo {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        Lights lights = new Lights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, lights);
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
