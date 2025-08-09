import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerguntaService {
    private List<Pergunta> perguntas = new ArrayList<>();

    public PerguntaService() {
        perguntas.add(new Pergunta(1L, "Quem foi o primeiro homem?", "Adão"));
        perguntas.add(new Pergunta(2L, "Quem foi o líder dos israelitas durante a saída do Egito?", "Moisés"));
        // Adicione mais perguntas aqui...
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public Pergunta getPergunta(Long id) {
        for (Pergunta pergunta : perguntas) {
            if (pergunta.getId().equals(id)) {
                return pergunta;
            }
        }
        return null;
    }

    public Pergunta criarPergunta(Pergunta pergunta) {
        perguntas.add(pergunta);
        return pergunta;
    }
}
