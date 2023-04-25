package med.voll.api.model.paciente;

public record ListaPacienteDTO(
    String nome,
    String email,
    String cpf
) {
    public ListaPacienteDTO(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
