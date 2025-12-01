package client.cep.demo.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import client.cep.demo.CepResultDTO;

@Service
public class CepConsumer {

    private final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = "cep-resposta", groupId = "cep-group")
    public void consumirResposta(String mensagemJson) {
        try {
            CepResultDTO dto = mapper.readValue(mensagemJson, CepResultDTO.class);
            System.out.println("📬 Resultado recebido do Kafka:");
            System.out.println(dto.getLogradouro() + ", " + dto.getBairro() + " - " + dto.getLocalidade());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
