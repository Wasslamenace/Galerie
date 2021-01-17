package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString


@Entity
public class Exposition{

    private float sommeVentes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NonNull
    private LocalDate debut;

    @Column
    @NonNull
    private String intitule;

    @Column
    @NonNull
    private int duree;


    @NonNull
    @ManyToOne
    private Galerie organisateur;

    @ManyToMany
    List<Tableau> oeuvres = new LinkedList<>();

    @OneToMany(mappedBy = "lieuVente")
    private List<Transaction> ventes;
    
    public List<Transaction> getTransactions() {
        return ventes;
    }

    public float CA(Integer id){
        
        this.sommeVentes = 0;
        ventes.forEach((v) -> {
            if(v.getLieuVente().id == id)
            this.sommeVentes += v.getPrixVente();
        });
        return this.sommeVentes;
    }
}
