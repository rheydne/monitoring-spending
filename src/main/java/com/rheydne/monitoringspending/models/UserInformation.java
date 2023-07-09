package com.rheydne.monitoringspending.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_information")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserInformation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 60)
    @NotNull
    @NotBlank
    @Size(min = 2, max = 60)
    private String fullName;

    @Column(name = "date_birth")
    private LocalDate dateBirth;

    @Column(name = "email_adress", nullable = false, length = 60)
    @NotNull
    @NotBlank
    @Size(min = 2, max = 60)
    private String emailAdress;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "userInformation")
    private List<Revenue> revenues = new ArrayList<Revenue>();

    @OneToMany(mappedBy = "userInformation")
    private List<Expense> expenses = new ArrayList<Expense>();
}
