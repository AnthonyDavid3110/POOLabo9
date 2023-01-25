import java.util.LinkedList;
import java.util.List;

/**
 * Classe principale du programme contenant le fonctionnement de ce dernier
 *
 * @author Anthony David
 * @date 25.01.2022
 */
class LotR {

    /**
     * Simulation du déroulement du programme comme dans la consigne
     */
    public LotR() {
        Personne frodo = new Personne("Frodon", Lieu.Comte);
        Ennemi sauron = new Ennemi("Sauron", Lieu.Destin);

        System.out.println("-1-");
        Anneau anneau = sauron.anneauUnique();

        System.out.println("-2-");
        anneau.utiliser();

        System.out.println("-3-");
        anneau.definirProprietaire(frodo);

        System.out.println("-4-");
        anneau.utiliser();

        System.out.println("-5-");
        anneau.detruire();

        System.out.println("-6-");
        frodo.deplacer(Lieu.Destin);

        System.out.println("-7-");
        anneau.detruire();

        System.out.println("---");
    }

    /**
     * Fonction main principale de programme
     *
     * @param args arguments de main (non utilisé dans ce programme)
     */
    public static void main(String... args) {
        new LotR();
        System.gc();
    }
}

/**
 * Classe représentant un anneau
 *
 * @author Anthony David
 */
abstract class Anneau {
    private String nom;
    private Personne proprietaire;

    /**
     * Constructeur de la classe
     *
     * @param nom          de l'anneau
     * @param proprietaire de l'anneau
     */
    public Anneau(String nom, Personne proprietaire) {
        this.nom = nom;
        System.out.println(proprietaire.lieu() + ": création de l'anneau " + this.nom + " par " + proprietaire.nom() + "!");
        definirProprietaire(proprietaire);
    }

    /**
     * Getter sur le propriétatire d'un anneau
     *
     * @return le propriétaire de l'anneau
     */
    public Personne proprietaire() {
        return proprietaire;
    }

    /**
     * Permet de détruire un anneau
     */
    public void detruire() {
        System.out.println("L'anneau " + nom + " est détruit.");
    }

    /**
     * Permet de définir un nouveau propriétaire pour un anneau définit
     *
     * @param personne nouveau propriétaire
     */
    public void definirProprietaire(Personne personne) {
        proprietaire = personne;
        System.out.println(proprietaire.nom() + " possède l'anneau " + nom + ".");
    }

    /**
     * Fonction qui simule l'utilisation de l'anneau
     * Doit être redéfinie
     */
    public abstract void utiliser();

}

class Personne {
    String nom;
    Lieu lieu;
    private static final List<Personne> personnes = new LinkedList<>();

    /**
     * Constructeur de Personne
     *
     * @param nom  de la personne
     * @param lieu où la personne est créée
     */
    public Personne(String nom, Lieu lieu) {
        this.nom = nom;
        this.lieu = lieu;
        personnes.add(this);
    }

    /**
     * Permet de dépplacer une personne d'un lieu à un autre
     *
     * @param lieu nouveau lieu de la personne
     */
    public void deplacer(Lieu lieu) {
        this.lieu = lieu;
        System.out.println(nom + " se déplace: " + lieu);
    }

    /**
     * Simule la mort d'une personne et la suppression de l'objet correspondant
     */
    public void mourir() {
        System.out.println(nom + " meurt!");
        personnes.remove(this);
    }

    /**
     * Redéfinition de la fonction de passage du ramasse-miette
     * Permet de supprimer définitevement une personne
     *
     * @note Déprécié depuis Java 9
     */
    protected void finalize() {
        System.out.println(nom + " rejoint le grand vide cosmique.");
    }

    /**
     * Getter sur le lieu où la personne se trouve
     *
     * @return Lieu où la personne se trouve
     */
    public Lieu lieu() {
        return lieu;
    }

    /**
     * Getter sur le nom de la personne
     *
     * @return le nom de la personne
     */
    public String nom() {
        return nom;
    }
}

/**
 * Classe représentant un ennemi
 *
 * @author Anthony David
 */
class Ennemi extends Personne {
    private Anneau anneauUnique;

    /**
     * Constructeur de ennemi
     *
     * @param nom  de l'ennemi
     * @param lieu où est ennemi à son initialisation
     */
    public Ennemi(String nom, Lieu lieu) {
        super(nom, lieu);
    }

    /**
     * Fonction permettant de définir l'anneau unique d'un ennemi
     *
     * @return l'anneau unique d'un ennemi
     */
    public Anneau anneauUnique() {
        if (anneauUnique != null) {
            return anneauUnique;
        }

        anneauUnique =
                new Anneau("unique", this) {
                    final Lieu creation = lieu();

                    public void utiliser() {
                        if (proprietaire() != Ennemi.this) {
                            System.out.println(proprietaire().nom() + " devient invisible!");
                        } else {
                            System.out.println(proprietaire().nom() + " est tout-puissant!");
                        }
                    }

                    public void detruire() {
                        System.out.println(proprietaire().lieu() + ": " + proprietaire().nom() + " tente de détruire l'anneau unique...");
                        if (proprietaire().lieu() != creation) {
                            System.out.println("L'anneau unique ne peut être détruit que là où il a été créé.");
                        } else {
                            super.detruire();
                            Ennemi.this.mourir();
                        }
                    }
                };
        return anneauUnique;

    }
}

/**
 * Enumération des lieux
 *
 * @author Anthony David
 */
enum Lieu {
    Comte("La Comté"),
    Destin("Le Mont du Destin");
    private final String nom;

    /**
     * Setter sur le lieu
     *
     * @param nom du nouveau lieu
     */
    Lieu(String nom) {
        this.nom = nom;
    }

    /**
     * Redéfinition de la fonction toString()
     *
     * @return le nom du lieu
     */
    public String toString() {
        return nom;
    }
}

