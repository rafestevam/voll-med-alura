package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void postCadastrar(@RequestBody @Valid MedicoDTO dadosMedico) {
        repository.save(new Medico(dadosMedico));
    }

    @GetMapping
    public Page<ListaMedicoDTO> getListaMedicos(@PageableDefault(size = 10, sort = {"nome"})  Pageable paginacao){
        //return repository.findAll(paginacao).stream().map(ListaMedicoDTO::new).toList();
        return repository.findAllByAtivoTrue(paginacao).map(ListaMedicoDTO::new);
    }

    @PutMapping
    @Transactional
    public void putUpdateMedico(@RequestBody @Valid AtualizaMedicoDTO dadosMedico){
        var medico = repository.getReferenceById(dadosMedico.id());
        medico.update(dadosMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteMedico(@PathVariable Long id){
        //repository.deleteById(id);
        var medico = repository.getReferenceById(id);
        medico.delete();
    }

}
