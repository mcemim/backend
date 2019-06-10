package com.zero2one.products.reposioty;

import com.zero2one.products.model.Product;
import com.zero2one.products.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findAllByName(String name);



}
