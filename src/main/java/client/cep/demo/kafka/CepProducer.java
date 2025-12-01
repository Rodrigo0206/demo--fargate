package client.cep.demo.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CepProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public CepProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarCep(String cep) {
        kafkaTemplate.send("cep-solicitacao", cep);
        System.out.println("✅ CEP enviado para o Kafka: " + cep);
    }
}
