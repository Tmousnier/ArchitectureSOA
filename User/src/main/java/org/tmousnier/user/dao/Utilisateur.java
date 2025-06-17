package org.tmousnier.user.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @UuidGenerator
    private String uuid;

    private String email;
    private String password;
}
