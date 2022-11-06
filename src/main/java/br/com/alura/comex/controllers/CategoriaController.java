package br.com.alura.comex.controllers;

import br.com.alura.comex.controllers.dto.CategoriaDto;
import br.com.alura.comex.controllers.dto.PedidoPorCategoriaDto;
import br.com.alura.comex.controllers.dto.RelatorioCategoriaDto;
import br.com.alura.comex.controllers.form.CategoriaForm;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService crudCategoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriBuilder) {

        System.out.println(form.getNome());

        Categoria c = form.converter();
        crudCategoriaService.salvar(c);

        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(c.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(c.getId(), c.getNome()));
    }

    @GetMapping
    public List<CategoriaDto> lista() {
        Iterable<Categoria> categorias = crudCategoriaService.visualizar();

        return CategoriaDto.converter((List<Categoria>) categorias);
    }

    @GetMapping
    @RequestMapping("/pedidos")
    @Cacheable(value = "relatorioPedidos")
    public ResponseEntity<RelatorioCategoriaDto> relatorioPedidoPorCategoria() {
        List<PedidoPorCategoriaDto> pedidoPorCategoriaDtos = crudCategoriaService.relatorioPedidoCategoria();
        return ResponseEntity.ok(new RelatorioCategoriaDto(pedidoPorCategoriaDtos));
    }
}