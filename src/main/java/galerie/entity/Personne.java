package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NonNull
    private float budgetAnnuel;

    @Column(unique = true)
    private String nom;

    @Column(unique = true)
    @NonNull
    private String adresse;

    @OneToMany(mappedBy = "client")

    private List<Transaction> achats;

    public List<Transaction> getTransactions() {
        return achats;
    }

    public float budgetArt(int annee){
        
        this.budgetAnnuel = 0;
        
        achats.forEach(a ->{
           if (a.getVenduLe().getYear() == annee){
               this.budgetAnnuel += a.getPrixVente();
           }
        });
        return this.budgetAnnuel;
    }
}
