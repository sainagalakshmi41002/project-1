package com.SpringBoot.project1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long orderId;
    private long orderDate;
    private String customerName;
    private String orderPayment;
    private String deleverAdress;

    @JoinColumn(name = "customerEmail")
    private String customerEmail;

}
