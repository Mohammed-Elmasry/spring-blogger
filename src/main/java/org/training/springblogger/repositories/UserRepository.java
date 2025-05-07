package org.training.springblogger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.springblogger.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
