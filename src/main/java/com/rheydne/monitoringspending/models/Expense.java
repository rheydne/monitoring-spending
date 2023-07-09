package com.rheydne.monitoringspending.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "expense")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Expense {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "description", nullable = false, length = 20)
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String description;

    @Column(name = "value", nullable = false, precision = 10, scale = 2)
    @NotNull
    @NotBlank
    @DecimalMin(value = "0.00", inclusive = false)
    private double value;

    @Column(name = "date_payment", nullable = false)
    @NotNull
    @NotBlank
    private LocalDate datePayment;

    @OneToOne
    @JoinColumn(name = "category_id", nullable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_information_id", nullable = false, updatable = false)
    private UserInformation userInformation;
}
