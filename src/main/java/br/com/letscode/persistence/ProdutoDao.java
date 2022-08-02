package br.com.letscode.persistence;

import br.com.letscode.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoDao {

    List<Produto> findAll();


    Produto save(Produto produto);

   Optional<Produto> findById(int id);

    List<Produto> delete(int id);
}
