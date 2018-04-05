import com.olbati.Panier;
import com.olbati.Produit;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PanierTest {

    private Panier panier = new Panier();

    @Test
    public void should_nouveau_panier_est_vide() {
        // Arrange

        // Act
        List<Produit> produits = panier.consulterProduits();

        // Assert
        assertThat(produits).isEmpty();
    }

    @Test
    public void should_ajouter_2_produit_et_retourner_ces_produits() {
        // Arrange
        Produit produit1 = new Produit("produit_1", BigDecimal.ONE);
        Produit produit2 = new Produit("produit_2", BigDecimal.TEN);

        // Act
        panier.ajouterProduit(produit1);
        panier.ajouterProduit(produit2);
        List<Produit> produits = panier.consulterProduits();

        // Assert
        assertThat(produits).hasSize(2);
        assertThat(produits.get(0)).isEqualTo(produit1);
        assertThat(produits.get(1)).isEqualTo(produit2);
    }

    @Test
    public void should_supprime_un_produit() {
        // Arrange
        Produit produit1 = new Produit("produit_1", BigDecimal.ONE);
        Produit produit2 = new Produit("produit_2", BigDecimal.TEN);
        panier.ajouterProduit(produit1);
        panier.ajouterProduit(produit2);

        // Act
        panier.supprimerProduit("produit_1");

        // Assert
        List<Produit> produits = panier.consulterProduits();
        assertThat(produits).hasSize(1);
        assertThat(produits.get(0)).isEqualTo(produit2);
    }

    @Test
    public void should_retourne_montant_total_panier() {
        // Arrange
        Produit produit1 = new Produit("produit_1", BigDecimal.ONE);
        Produit produit2 = new Produit("produit_2", BigDecimal.TEN);
        panier.ajouterProduit(produit1);
        panier.ajouterProduit(produit2);

        // Act
        BigDecimal montantTotal = panier.montantTotal();

        // Assert
        assertThat(montantTotal).isEqualTo(BigDecimal.valueOf(11L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_nomProduit_nul_a_supprimer() {
        panier.supprimerProduit(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_produit_nul_a_ajouter() {
        panier.ajouterProduit(null);
    }


}
