package at.johannesfelzmann.model;

import at.johannesfelzmann.enumeration.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author Johannes Felzmann
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    @NotEmpty(message = "Name cannot be empty!")
    private String name;
    private String text;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<File> images = new HashSet<>();
    private Category category;
    private String author;
}
