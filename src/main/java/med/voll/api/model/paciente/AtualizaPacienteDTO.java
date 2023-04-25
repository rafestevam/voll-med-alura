package med.voll.api.model.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.endereco.EnderecoDTO;

public record AtualizaPacienteDTO(
    @NotNull
    Long id,
    String nome,
    String telefone,
    EnderecoDTO endereco
) {
}
