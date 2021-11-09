

public class Test {
    static Controleur c;
    static ProgressExemple pe;

    public Test() {
    }

    public static void main(String[] argv) throws InterruptedException {
        Thread p = new Thread(new Progression());
        Thread j = new Thread(new Jeu());
        p.start();
        j.start();
        p.join();
        j.join();
    }
}