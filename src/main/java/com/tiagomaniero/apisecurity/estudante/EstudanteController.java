package com.tiagomaniero.apisecurity.estudante;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class EstudanteController {

    private static final List<Estudante> ESTUDANTES = Arrays.asList(
            new Estudante(1, "James"),
            new Estudante(2, "Maria"),
            new Estudante(3, "Jorge")
    );

    @GetMapping("/{id}")
    public Estudante retornarEstudante(@PathVariable(value = "id") Integer estudanteId){
        return ESTUDANTES.stream()
                .filter(estudante -> estudanteId.equals(estudante.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Estudante id:" + estudanteId + "não existe"));

    }
}
