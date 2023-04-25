package med.voll.api.model.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.endereco.Endereco;
import med.voll.api.model.endereco.EnderecoDTO;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(MedicoDTO dadosMedico) {
        this.nome = dadosMedico.nome();
        this.email = dadosMedico.email();
        this.telefone = dadosMedico.telefone();
        this.crm = dadosMedico.crm();
        this.especialidade = dadosMedico.especialidade();
        this.endereco = new Endereco(dadosMedico.endereco());
        this.ativo = true;
    }

    public void update(AtualizaMedicoDTO dadosMedico) {
        this.nome = dadosMedico.nome() != null ? dadosMedico.nome() : this.nome;
        this.telefone = dadosMedico.telefone() != null ? dadosMedico.telefone() : this.telefone;

        if(dadosMedico.endereco() != null) { this.endereco.update(dadosMedico.endereco()); }
    }

    public void delete() {
        this.ativo = false;
    }
};
