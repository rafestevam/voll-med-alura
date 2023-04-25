package med.voll.api.model.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(PacienteDTO dadosPaciente) {
        this.nome = dadosPaciente.nome();
        this.email = dadosPaciente.email();
        this.telefone = dadosPaciente.telefone();
        this.cpf = dadosPaciente.cpf();
        this.endereco = new Endereco(dadosPaciente.endereco());
        this.ativo = true;
    }

    public void update(AtualizaPacienteDTO dadosPaciente) {
        this.nome = dadosPaciente.nome() != null ? dadosPaciente.nome() : this.nome;
        this.telefone = dadosPaciente.telefone() != null ? dadosPaciente.telefone() : this.telefone;

        if(dadosPaciente.endereco() != null) { this.endereco.update(dadosPaciente.endereco()); }
    }

    public void delete() {
        this.ativo = false;
    }
}
