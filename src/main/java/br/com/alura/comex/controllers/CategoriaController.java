package br.com.alura.comex.controllers;

import br.com.alura.comex.controllers.dto.CategoriaDto;
import br.com.alura.comex.controllers.form.CategoriaForm;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.repositories.CategoriaRepository;
import br.com.alura.comex.services.CrudCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CrudCategoriaService crudCategoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriBuilder) {

        System.out.println(form.getNome());

        Categoria c = form.converter();
        crudCategoriaService.salvar(c);

        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(c.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(c));
    }

    @GetMapping
    @RequestMapping("/pedidos")
    public void relatorioPedidoPorCategoria() {

    }
}