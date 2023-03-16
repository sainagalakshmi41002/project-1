package com.SpringBoot.project1.EntityDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdresDTO{

        private long orderId;
        private long orderDate;
        private String customerName;
        private String orderPayment;
        private String deleverAdress;

    }

