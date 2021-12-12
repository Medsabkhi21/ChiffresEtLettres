
import javax.swing.*;

public class Barre extends JMenuBar {

    private JMenu Jouer, Aide;
    private JMenuItem mode_joueur, mode_chiffres, fermer;
    private JMenuItem help, information;

    Barre() {
        this.Jouer = new JMenu("Fichier");
        this.Aide = new JMenu("Aide");
        this.mode_joueur = new JMenuItem("Mode Lettres");
        this.mode_chiffres = new JMenuItem("Mode Chiffres");
        this.fermer = new JMenuItem("Fermer");

        this.help = new JMenuItem("Aide");
        this.information = new JMenuItem("Information");

        this.Jouer.add(mode_joueur);
        this.Jouer.add(mode_chiffres);
        this.Jouer.add(fermer);

        this.Aide.add(help);
        this.Aide.add(information);

        this.add(Jouer);
        this.add(Aide);
    }


    //setters and getters for Barre attributes
    JMenu getMenuJouer() {
        return this.Jouer;
    }

    JMenu getMenuAide() {
        return this.Aide;
    }

    JMenuItem getItemModeJoueur() {
        return this.mode_joueur;
    }

    JMenuItem getItemModeChiff() {
        return this.mode_chiffres;
    }

    JMenuItem getItemFermer() {
        return this.fermer;
    }

    JMenuItem getItemHelp() {
        return this.help;
    }

    JMenuItem getItemInformation() {
        return this.information;
    }

    void setMenuJouer(JMenu j) {
        this.Jouer = j;
    }

    void setMenuAide(JMenu a) {
        this.Aide = a;
    }

    void setItemModeJoueur(JMenuItem mj) {
        this.mode_joueur = mj;
    }

    void setItemModeOrdinateur(JMenuItem mo) {
        this.mode_chiffres = mo;
    }

    void setItemFermer(JMenuItem f) {
        this.fermer = f;
    }

    void setItemHelp(JMenuItem h) {
        this.help = h;
    }

    void setItemInformation(JMenuItem i) {
        this.information = i;
    }

}
