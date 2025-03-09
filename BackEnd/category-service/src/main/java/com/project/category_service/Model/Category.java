package com.project.category_service.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="category")
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cid;

    private String title;

    private String description;


}
