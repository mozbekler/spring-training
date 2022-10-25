package com.cydeo.entity;

import lombok.NoArgsConstructor;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="Merchants")
@NoArgsConstructor

public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private BigDecimal transactionFee;
    private BigDecimal commissionRate;
    private Integer payoutDelayCount;

    @OneToMany(mappedBy = "merchant") //in OneToMany relationship, ownership belongs to Many side
    private List<Payment> paymentList;

    public Merchant(String name, String code, BigDecimal transactionFee, BigDecimal commissionRate, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.transactionFee = transactionFee;
        this.commissionRate = commissionRate;
        this.payoutDelayCount = payoutDelayCount;
    }


}
