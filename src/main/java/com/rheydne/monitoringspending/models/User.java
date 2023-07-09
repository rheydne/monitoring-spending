package com.rheydne.monitoringspending.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "username", unique = true, length = 100, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 2, max = 100)
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "password", length = 60, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 8, max = 60)
    private String password;

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

    @OneToMany(mappedBy = "user")
    private List<Revenue> revenues = new ArrayList<Revenue>();

    @OneToMany(mappedBy = "user")
    private List<Expense> expenses = new ArrayList<Expense>();
}
