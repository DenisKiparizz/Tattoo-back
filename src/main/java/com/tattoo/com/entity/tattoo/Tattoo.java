package com.tattoo.com.entity.tattoo;

import com.tattoo.com.entity.order.Order;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "tattoos")
public class Tattoo{
    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 20, message = "Name of Picture has to be in the range: 1 - 20")
    @Column(name = "picture")
    private String picture;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private Integer cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "style_id")
    private Style style;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "tattoo", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}
