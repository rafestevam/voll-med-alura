package med.voll.api.model.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.endereco.EnderecoDTO;

public record AtualizaMedicoDTO(
    @NotNull
    Long id,
    String telefone,
    String nome,
    EnderecoDTO endereco
) {

}
