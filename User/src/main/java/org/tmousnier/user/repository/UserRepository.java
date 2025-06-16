package org.tmousnier.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tmousnier.user.dao.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
