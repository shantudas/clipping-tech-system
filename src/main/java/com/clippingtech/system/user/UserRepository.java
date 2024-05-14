package com.clippingtech.system.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Page<UserEntity> findByFirstNameLikeOrLastNameLike(String firstNameLike, String lastNameLike, Pageable pageable);
}
