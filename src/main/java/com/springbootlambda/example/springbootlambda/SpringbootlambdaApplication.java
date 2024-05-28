package com.springbootlambda.example.springbootlambda;

import com.springbootlambda.example.springbootlambda.model.Book;
import com.springbootlambda.example.springbootlambda.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringbootlambdaApplication {

	@Autowired
	private BookDao bookDao;

	@Bean
	public Supplier<List<Book>> findBook(){ //all the method annotated with bean and of type function/supplier/consumer are api end points
		return ()->bookDao.buildBooks();
	}

	@Bean
	public Function<String, List<Book>> findBookByName(){ // method name are apiendpoint using spring cloud function dependencies
		return (input)->bookDao.buildBooks().stream().filter(book ->book.getName().equals(input)).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootlambdaApplication.class, args);
	}

}
