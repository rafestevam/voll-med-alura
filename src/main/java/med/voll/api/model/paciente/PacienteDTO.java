package med.voll.api.model.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.model.endereco.EnderecoDTO;

public record PacienteDTO(
    @NotBlank
    String nome,
    @NotBlank
    @Email
    String email,
    @NotBlank
    String telefone,
    @NotBlank
    String cpf,
    @NotNull
    @Valid
    EnderecoDTO endereco
){ }
