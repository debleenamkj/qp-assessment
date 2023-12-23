package com.qpassessment.grocery.booking.repository;

import com.qpassessment.grocery.booking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

