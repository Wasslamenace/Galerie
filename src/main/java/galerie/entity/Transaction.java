package galerie.entity;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString


@Entity
public class Transaction{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NonNull
    private LocalDate venduLe;

    @Column
    @NonNull
    private Float prixVente;

    @ManyToOne
    private Exposition lieuVente;

    @ManyToOne
    private Personne client;

    @OneToOne
    private Tableau oeuvre;

}
