package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void postCadastrar(@RequestBody @Valid PacienteDTO dadosPaciente){
        repository.save(new Paciente(dadosPaciente));
    }

    @GetMapping
    public Page<ListaPacienteDTO> getListaPacientes(@PageableDefault(size = 10, sort = {"nome"})Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(ListaPacienteDTO::new);
    }

    @PutMapping
    @Transactional
    public void putUpdatePaciente(@RequestBody @Valid AtualizaPacienteDTO dadosPaciente){
        var paciente = repository.getReferenceById(dadosPaciente.id());
        paciente.update(dadosPaciente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePaciente(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.delete();
    }
}
