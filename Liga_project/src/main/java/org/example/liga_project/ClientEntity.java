package org.example.liga_project;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Table(name = "client_account")
@Entity
public class ClientEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender",length = 1)
    private ClientGender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",length = 20)
    private ClientStatus status;

    @NotNull
    @Column(name = "create_dttm")
    private LocalDateTime dateOfCreate;

    @NotNull
    @Column(name = "modify_dttm")
    private LocalDateTime dateOfUpdate;

    public ClientEntity() {
    }

    public ClientEntity(Long id, String fullName,
                        ClientGender gender, ClientStatus status,
                        LocalDateTime dateOfCreate, LocalDateTime dateOfUpdate) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.status = status;
        this.dateOfCreate = dateOfCreate;
        this.dateOfUpdate = dateOfUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
    }

    public ClientGender getGender() {
        return gender;
    }

    public void setGender(ClientGender gender) {
        this.gender = gender;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(LocalDateTime date_of_create) {
        this.dateOfCreate = date_of_create;
    }

    public LocalDateTime getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(LocalDateTime date_of_update) {
        this.dateOfUpdate = date_of_update;
    }
}
