

@RestController
@RequestMapping("/cep")
public class CepController {

    private final CepProducer cepProducer;

    public CepController(CepProducer cepProducer) {
        this.cepProducer = cepProducer;
    }

    @PostMapping("/{cep}")
    public String enviarCep(@PathVariable String cep) {
        cepProducer.enviarCep(cep);
        return "CEP enviado: " + cep;
    }
}
