package org.example.springblogjpamysql.repository;

import org.example.springblogjpamysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
