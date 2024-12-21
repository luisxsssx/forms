package com.backend.forms.repository;

import com.backend.forms.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {

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

    // Update user data
    @Modifying
    @Query(value = "CALL update_user_data(:p_user_id, :p_first_name, :p_last_name, :p_email, :p_age)", nativeQuery = true)
    void updateUser(@Param("p_user_id") Integer user_id,
                  @Param("p_first_name") String first_name,
                  @Param("p_last_name") String last_name,
                  @Param("p_email") String email,
                  @Param("p_age") String age);

    // Update user password
    @Modifying
    @Query(value = "CALL update_user_password(:p_user_id, :p_password)", nativeQuery = true)
    void updatePassword(@Param("p_user_id") Integer user_id,
                        @Param("p_password") String password);

    // Delete user
    @Modifying
    @Query(value = "CALL delete_user(:p_user_id)", nativeQuery = true)
    void deleteUser(@Param("p_user_id") Integer user_id);
}