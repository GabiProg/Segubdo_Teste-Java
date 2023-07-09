package segundoteste;
import java.util.ArrayList;
import java.util.List;

public class Segundo {
    private Integer ultimoId = 0;
    private ArrayList<Candidato> candidatos = new ArrayList<Candidato>();

    //#region Main
    public static void main(String[] args) {
        
       Segundo sengundo = new Segundo();
    }
    //#endregion

    //#region Iniciar o Processo
    public int iniciarProcesso(String nome) {
        for (Candidato candidato : candidatos) {
            if(candidato.getNome().equals(nome)) {
                System.out.println("Candidato já participa do processo.");
            }
        }
        Integer id = ultimoId++;
        Candidato candidato = new Candidato (id, nome, "Recebido");
        candidatos.add(candidato);
        return id;
    }
    //#endregion

    public void marcarEntrevista(int codCandidato) {
        for (Candidato candidato : candidatos) {
            if (candidato.getId() == codCandidato){
                candidato.setStatus("Qualificado");
                break;
            }
        }
        System.out.println("Candidato não encontrado");
    }

    public void desqualificarCandidato(int codCandidato){
        Candidato candidato = candidatos.get(codCandidato);
        if (candidato != null) {
            candidatos.remove(codCandidato);
        } else {
            System.out.println("Candidato não encontrado");
        }
    }

    public String verificarStatusCandidato(int codCandidato) {
        Candidato candidato = candidatos.get(codCandidato);
        if (candidato != null) {
            String status = candidato.getStatus();
            return status;
        } else {
            return "Candidato não encontrado";
        }
    }

    public void aprovarCandidato(int codCandidato) {
        Candidato candidato = candidatos.get(codCandidato);
        if (candidato != null) {
            candidato.setStatus("Aprovado");
        } else {
            System.out.println("Candidato não encontrado");
        }
    }

    public List<String> obterAprovados() {
        List<String> aprovados = new ArrayList<String>();
        for (Candidato candidato : candidatos) {
            if (candidato.getStatus().equals("Aprovados")){
                aprovados.add(candidato.getNome());
            }
        }
        return aprovados;
    }

    public class Candidato {
        private Integer id;
        private String nome;
        private String status;

        public Candidato(Integer id, String nome, String status) {
            this.id = id;
            this.nome = nome;
            this.status = status;
        }

        public Integer getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

}
