# POO - Laboratoire 9
## Consigne


Durée du laboratoire: 3 périodes

Il y a très longtemps, dans la Terre du Milieu, le grand ennemi Sauron forgea un anneau magique, l’Anneau Unique, dans les forges du Mont du Destin. Cet anneau conférait un grand pouvoir à Sauron et ne pouvait être détruit que là où il avait été créé. Par le plus grand des hasards cet anneau tomba dans les mains d’un courageux Hobbit de la Comté nommé Frodo qui entreprit une quête pour le détruire. Après bien des péripéties, Frodo réussit à parvenir au Mont du Destin et à détruire l’anneau, mettant ainsi fin au règne de Sauron.

Soit le programme,

class LotR {
public LotR() {
Personne frodo = new Personne("Frodo", Lieu.Comte);
Ennemi sauron  = new Ennemi("Sauron", Lieu.Destin);

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

public static void main(String ... args)  {
new LotR();
System.gc();
}
}

et le résultat de son exécution,

-1-
Le Mont du Destin: création de l'anneau unique par Sauron!
Sauron possède l'anneau unique.
-2-
Sauron est tout-puissant!
-3-
Frodo possède l'anneau unique.
-4-
Frodo devient invisible!
-5-
La Comté: Frodo tente de détruire l'anneau unique...
L'anneau unique ne peut être détruit que là où il a été créé.
-6-
Frodo se déplace: Le Mont du Destin
-7-
Le Mont du Destin: Frodo tente de détruire l'anneau unique...
L'anneau unique est détruit.
Sauron meurt!
---
Sauron rejoint le grand vide cosmique.

    Définir le type énuméré Lieu permettant de représenter des lieux de la Terre du Milieu de manière à ce que les instructions, System.out.println(Lieu.Comte) et System.out.println(Lieu.Destin) affichent respectivement “La Comté” et “Le Mont du Destin”.

    Compléter les classe Personne et Anneau ci-dessous et définir une classe Ennemi (et seulement celles-ci) afin que l’exécution du programme de test produise le résultat attendu.

public class Personne {
private String nom;
private Lieu lieu;

public void mourir() {
System.out.printf("%s meurt!\n", nom);
}
}

public abstract class Anneau {
private String nom;
private Personne propriétaire;

public void detruire() {
System.out.printf("L'anneau %s est détruit.\n", nom);
}
}

Indications:

    la classe Personne doit permettre le stockage dans une liste de toutes les personnes qui sont actuellement vivantes; la méthode afficherPersonnes doit pouvoir les afficher (leurs noms et types),

    la classe Anneau représente n’importe quel type d’anneau magique, chaque type d’anneau possède un pouvoir spécifique, lors de sa création un anneau est la propriété de son créateur,

    un ennemi ne peut créér qu’un seul anneau spécifique, ainsi la méthode public Anneau anneauUnique() rend l’anneau d’un ennemi s’il existe et le crée sinon,

    l’anneau d’un ennemi confère un pouvoir immense à son créateur, par contre, s’il est utilisé par une autre personne, il la rend simplement invisible,

    l’anneau d’un ennemi ne peut être détruit que là où il a été créé et sa destruction entraine la mort de son créateur,

    penser à profiter des propriétés des classes internes.

