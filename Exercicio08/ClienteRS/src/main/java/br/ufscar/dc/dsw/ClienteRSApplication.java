package br.ufscar.dc.dsw;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ufscar.dc.dsw.domain.Teste;
import br.ufscar.dc.dsw.service.spec.IRestClientService;

@SpringBootApplication
public class ClienteRSApplication {

	private static final Logger log = LoggerFactory.getLogger(ClienteRSApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ClienteRSApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(IRestClientService service) throws Exception {
		return args -> {
			
			Teste t = new Teste("Teste Body", "Teste Title", (long) 1);
			log.info("-----------------------------------");
			log.info("save()");
			log.info("-----------------------------------");
			Long id = service.create(t);
			log.info("Salvo Teste [" + id + "]" + t.toString());
			log.info("-----------------------------------");
			log.info("getTestes()");
			log.info("-----------------------------------");
			List<Teste> ts = service.get();
			for (Teste c : ts) {
				log.info(c.toString());
			}
			log.info("-----------------------------------");
			log.info("Numero de Testes: " + ts.size());
			log.info("-----------------------------------");
			log.info("getTeste(" + id + ")");
			log.info("-----------------------------------");
			t = service.get(id);
			for (Teste c : ts) {
				log.info(c.toString());
			}
			log.info("-----------------------------------");
			log.info("Numero de Testes: " + ts.size());
			log.info("-----------------------------------");
			t.setBody("Teste Body atualizado");
			t.setTitle("Teste Title atualizado");
			boolean ok = service.update(t);
			log.info("update (" + id + ") " + ok);
			log.info("-----------------------------------");
			log.info("getTeste (" + id + ")");
			log.info("-----------------------------------");
			t = service.get(id);			
			log.info(t.toString());
			log.info("-----------------------------------");
			ok = service.delete(id);
			log.info("remove (" + id + ") " + ok);
			log.info("-----------------------------------");
			ts = service.get();
			log.info("Numero de Testes: " + ts.size());
			log.info("-----------------------------------");
		};
	}
}
