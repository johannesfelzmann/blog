package at.johannesfelzmann.model;

import at.johannesfelzmann.enumeration.Visual;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author Johannes Felzmann
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    @NotEmpty(message = "Name cannot be empty!")
    private String name;
    private String text;
    private String image;
    private Visual visual;
}
