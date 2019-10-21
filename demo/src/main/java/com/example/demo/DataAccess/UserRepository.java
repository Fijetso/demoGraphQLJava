package com.example.demo.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Book;

public interface UserRepository extends JpaRepository<Book,Long>{

}
