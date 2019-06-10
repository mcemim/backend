package com.zero2one.products.controller;

import com.zero2one.products.model.Product;
import com.zero2one.products.model.Produto;
import com.zero2one.products.reposioty.ProductRepository;
import com.zero2one.products.reposioty.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/produtos")
@Api(tags = "Produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    @ApiOperation("Listagem de produtos")
    public Collection<Produto> get(@RequestParam(required = false, value = "name") String name) {
        if (name != null) {
            return repository.findAllByName(name);
        }
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id, @AuthenticationPrincipal Principal principal) {
        Produto produto = repository.findById(id).orElse(null);
        if (produto == null) {
            return ResponseEntity.notFound()
                    .header("", "")
                    .build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @PostMapping
    @Transactional
    public Produto create(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatename(@PathVariable("id") Integer id, @RequestBody String name) {
        Produto produto = repository.findById(id).orElse(null);
        if (produto == null) {
            return ResponseEntity.notFound()
                    .header("", "")
                    .build();
        }
        else {
            produto.setName(name);
            repository.save(produto);
            return ResponseEntity.status(HttpStatus.OK).body(produto);
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

}
