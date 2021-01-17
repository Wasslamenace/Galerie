package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.List;
import java.util.LinkedList;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString

@Entity

public class Tableau{
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(unique = true)
    @NonNull
    public String titre;

    @Column
    @NonNull
    public String support;

    @Column
    @NonNull
    public Integer largeur;

    @Column
    @NonNull
    public Integer hauteur;
    
    @ManyToMany(mappedBy = "oeuvres")
    List<Exposition> accrochages = new LinkedList<>();

    @OneToOne(mappedBy = "oeuvre")
    private Transaction vendu;

    @ManyToOne
    private Artiste auteur;


}