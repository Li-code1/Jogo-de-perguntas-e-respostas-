import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PerguntaController {
    @Autowired
    private PerguntaService perguntaService;

    @GetMapping("/perguntas")
    public List<Pergunta> getPerguntas() {
        return perguntaService.getPerguntas();
    }

    @GetMapping("/perguntas/{id}")
    public ResponseEntity<Pergunta> getPergunta(@PathVariable Long id) {
        Pergunta pergunta = perguntaService.getPergunta(id);
        if (pergunta != null) {
            return ResponseEntity.ok(pergunta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/perguntas")
    public Pergunta criarPergunta(@RequestBody Pergunta pergunta) {
        return perguntaService.criarPergunta(pergunta);
    }

    @PostMapping("/perguntas/{id}/responder")
    public ResponseEntity<String> responderPergunta(@PathVariable Long id, @RequestBody String resposta) {
        Pergunta pergunta = perguntaService.getPergunta(id);
        if (pergunta != null) {
            if (pergunta.getResposta().equalsIgnoreCase(resposta)) {
                return ResponseEntity.ok("Resposta certa!");
            } else {
                return ResponseEntity.ok("Resposta errada! A resposta certa é " + pergunta.getResposta());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
