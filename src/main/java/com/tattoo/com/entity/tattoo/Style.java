package com.tattoo.com.entity.tattoo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "style")
public class Style {
    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "style")
    private String style;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "style", cascade = CascadeType.ALL)
    private List<Tattoo> tattoos = new ArrayList<>();

    public Style(Long id, String style) {
        this.id = id;
        this.style = style;
    }
}
