package com.backend.forms.repository;

import com.backend.forms.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    // Insert user information
    @Modifying
    @Query(value = "CALL save_users(:first_name, :last_name, :email, :age, :password)", nativeQuery = true)
    void saveUser(@Param("first_name") String first_name,
                  @Param("last_name") String last_name,
                  @Param("email") String email,
                  @Param("age") String age,
                  @Param("password") String password);


    // Get user information
    @Modifying
    @Query(value = "SELECT * FROM get_users()", nativeQuery = true)
    List<UserModel> getAllUsers();
}