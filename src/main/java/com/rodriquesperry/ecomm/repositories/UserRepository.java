package com.rodriquesperry.ecomm.repositories;

import com.rodriquesperry.ecomm.models.Product;
import com.rodriquesperry.ecomm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(long id);
}
