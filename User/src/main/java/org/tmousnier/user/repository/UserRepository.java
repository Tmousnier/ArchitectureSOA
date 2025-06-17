package org.tmousnier.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tmousnier.user.dao.Utilisateur;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, String> {
    Optional<Utilisateur> findByEmail(String email);
}
