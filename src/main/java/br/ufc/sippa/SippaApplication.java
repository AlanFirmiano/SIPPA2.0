package br.ufc.sippa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(value={"br.ufc.sippa","br.ufc.sippa.service","br.ufc.sippa.repository","br.ufc.sippa.controller","br.ufc.sippa.model"})
public class SippaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SippaApplication.class, args);
	}
}
