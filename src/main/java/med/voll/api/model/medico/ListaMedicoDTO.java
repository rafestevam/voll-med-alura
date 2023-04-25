package med.voll.api.model.medico;

public record ListaMedicoDTO(
        Long id,
        String nome,
        String email,
        String crm,
        EspecialidadeEnum especialidade,
        Boolean ativo
) {
    public ListaMedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getAtivo());
    }
}
