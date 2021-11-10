package br.ufscar.dc.dsw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;
import static java.util.Arrays.sort;
import static java.util.Collections.sort;
import br.ufscar.dc.dsw.dao.ILivroDAO;
import br.ufscar.dc.dsw.domain.Livro;
import br.ufscar.dc.dsw.domain.Editora;

@SpringBootApplication
public class LivrariaJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(LivrariaJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LivrariaJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ILivroDAO dao) {
		return (args) -> {

			// Recupere todos livros

			log.info("Livros recuperados -- findAll():");
			log.info("--------------------------------");
			for (Livro livro : dao.findAll()) {
				log.info(livro.toString());
			}
			log.info("");

			// Recupere um livro por seu ID

			Livro livro = dao.findById(1L);
			if (livro != null) {
				log.info("Livro recuperado -- findById(1L):");
				log.info("---------------------------------");
				log.info(livro.toString());
				log.info("");
				
				Editora ed = livro.getEditora();
				Livro livro1 = new Livro("A Revolucao dos Bichos", "George Orwell", 2007, BigDecimal.valueOf(23.9), ed);
				dao.save(livro1);
				log.info("Livro inserido com sucesso");
				log.info(livro1.toString());
				
				log.info("\nLivros recuperados -- findAllByOrderByPreco():");
				for (Livro livro2 : dao.findAllByOrderByPrecoAsc()) {
					log.info("\n--------------------------------");
					log.info(livro2.toString());
				}
				log.info("");
			}
		};
	}
}