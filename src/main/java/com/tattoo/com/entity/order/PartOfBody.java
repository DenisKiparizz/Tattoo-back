package com.tattoo.com.entity.order;

import com.tattoo.com.entity.review.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "part_of_body")
public class PartOfBody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "part")
    @Enumerated(EnumType.STRING)
    private EPartOfBody part;

    @Column(name = "rate")
    private Double rate;

    @OneToOne (mappedBy="partOfBody")
    private Order order;
}
