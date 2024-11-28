import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {

    @Test
    void testAjouterMatiere() {
        Etudiant etudiant = new Etudiant(1); // Année 1
        Matiere matiere = new Matiere("MATH101", "Mathématiques");
        etudiant.ajouterMatiere(matiere);

        // Vérifie que la matière a bien été ajoutée
        assertEquals(1, etudiant.matieres.size());
        assertEquals("Mathématiques", etudiant.matieres.get(0).getNom());
    }

    @Test
    void testCalculeMoyenneGenerale_SansMatiere() {
        Etudiant etudiant = new Etudiant(2); // Année 2
        assertEquals(0, etudiant.calculeMoyenneGenerale(), 0.01);
    }

    @Test
    void testCalculeMoyenneGenerale_AvecMatieresEtEvaluations() {
        Etudiant etudiant = new Etudiant(3); // Année 3

        // Crée et configure les matières avec des évaluations
        Matiere math = new Matiere("MATH101", "Mathématiques");
        math.ajouterEvaluation(new Evaluation("Devoir 1", 16));
        math.ajouterEvaluation(new Evaluation("Examen final", 14));

        Matiere physique = new Matiere("PHYS101", "Physique");
        physique.ajouterEvaluation(new Evaluation("TP", 15));
        physique.ajouterEvaluation(new Evaluation("Examen final", 17));

        Matiere chimie = new Matiere("CHIM101", "Chimie");
        chimie.ajouterEvaluation(new Evaluation("Examen", 18));

        // Ajoute les matières à l'étudiant
        etudiant.ajouterMatiere(math);
        etudiant.ajouterMatiere(physique);
        etudiant.ajouterMatiere(chimie);

        // Calcule la moyenne générale
        float moyenneMath = (16 + 14) / 2.0f;
        float moyennePhysique = (15 + 17) / 2.0f;
        float moyenneChimie = 18;
        float moyenneAttendue = (moyenneMath + moyennePhysique + moyenneChimie) / 3.0f;

        assertEquals(moyenneAttendue, etudiant.calculeMoyenneGenerale(), 0.01);
    }
}
