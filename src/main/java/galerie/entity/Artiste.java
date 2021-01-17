package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString

@Entity
public class Artiste extends Personne{

    @Column(unique = true)
    @NonNull
    private String biographie;

    @OneToMany(mappedBy = "auteur")
    
    private List<Tableau> oeuvres;
    
    public List<Tableau> getTableaux() {
        return oeuvres;
    }
}