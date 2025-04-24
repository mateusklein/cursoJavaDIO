package com.dio.springboot;

import com.dio.springboot.springbeans.AppConfig;
import com.dio.springboot.springbeans.Autor;
import com.dio.springboot.springbeans.Livro;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);

		Livro livro = factory.getBean(Livro.class);
		livro.setNome("Harry Potter");
		livro.setCodigo("1234");
		Autor autor = factory.getBean(Autor.class);
		autor.setNome("J.K. Rowling");


		livro.exibir();


	}

}
