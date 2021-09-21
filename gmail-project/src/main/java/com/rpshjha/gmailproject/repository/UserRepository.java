package com.rpshjha.gmailproject.repository;

import com.rpshjha.gmailproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 08/09/21
 * Time: 10:52 AM
 * To change this template use File | Settings | File and Code Templates.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    Optional<User> findById(Integer primaryKey);

    long count();

}