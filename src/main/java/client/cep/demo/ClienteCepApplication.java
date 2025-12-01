package client.cep.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import client.cep.demo.kafka.CepProducer; // importa o produtor

@SpringBootApplication
public class ClienteCepApplication implements CommandLineRunner {

    @Autowired
    private CepProducer cepProducer; // injeta o produtor Kafka

    public static void main(String[] args) {
        SpringApplication.run(ClienteCepApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu CEP: ");
        String cep = scanner.nextLine();

        // Envia o CEP para o tópico Kafka
        cepProducer.enviarCep(cep);

        System.out.println("⏳ CEP enviado para o Kafka, aguardando resposta...");
    }
}
