package com.tattoo.com.entity.order;

import com.tattoo.com.entity.review.Review;
import com.tattoo.com.entity.tattoo.Tattoo;
import com.tattoo.com.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "part")
    @Enumerated(EnumType.STRING)
    private EPartOfBody part;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EStatus status;

    @Column(name = "price")
    private Double price;

    @OneToOne(mappedBy = "order", cascade = CascadeType.REMOVE)
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tattoo_id")
    private Tattoo tattoo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_user",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

}
