package galerie.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    
     @Column
    @NonNull
     private float cAnnuel;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    // TODO : Mettre en oeuvre la relation oneToMany vers Exposition
    
     @OneToMany(mappedBy = "organisateur")
    private List<Exposition> events = new ArrayList<>() ;
     
    public List<Exposition> getExpositions(){
        return events; 
    }

    public float CAannuel(int annee){
        this.cAnnuel = 0;
        events.forEach((e) -> {
           if(e.getDebut().getYear() == annee) {
               this.cAnnuel += e.CA(this.id);
           }
        });
        return this.cAnnuel;
    }

}
