package com.springbootlambda.example.springbootlambda.repository;

import com.springbootlambda.example.springbootlambda.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class BookDao {

    public List<Book> buildBooks(){
        return Stream.of(new Book(101,"Java Core",499),
                new Book(102,"J2EE",699),
                new Book(103,"Python",499),
                new Book(104,"Java Core",599))
                .collect(Collectors.toList());
    }
}
