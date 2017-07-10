package br.ufc.sippa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(value={"br.qxd.sippa","br.qxd.sippa.service","br.qxd.sippa.repository","br.qxd.sippa.api.controller"})
public class SippaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SippaApplication.class, args);
	}
}
