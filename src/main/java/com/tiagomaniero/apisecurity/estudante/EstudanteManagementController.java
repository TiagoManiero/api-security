package com.tiagomaniero.apisecurity.estudante;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class EstudanteManagementController {

    private static final List<Estudante> ESTUDANTES = Arrays.asList(
            new Estudante(1, "James"),
            new Estudante(2, "Maria"),
            new Estudante(3, "Jorge")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_ADMINTRAINEE')")
    public List<Estudante> retornarTodosEstudantes(){
        return ESTUDANTES;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('estudante:write')")
    public void inserirNovoEstudante(@RequestBody Estudante estudante){
        System.out.println(estudante);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('estudante:write')")
    public void deletarEstudante(@PathVariable(value = "id") Integer idEstudante){
        System.out.println(idEstudante);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('estudante:write')")
    public void alterarEstudante(@PathVariable(value = "id") Integer idEstudante,
                                 @RequestBody Estudante estudante){

        System.out.println(String.format("%s %s", estudante, idEstudante));
    }
}
