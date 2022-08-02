package br.com.letscode.persistence;

import br.com.letscode.model.Produto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProdutoDaoImpl implements ProdutoDao{

    private List<Produto> bancoDeProdutos = new ArrayList<>();

    @Override
    public List<Produto> findAll() {
        return bancoDeProdutos;
    }

    @Override
    public Produto save(Produto produto) {
        if (produto.getId() == null) {
            produto.setId(bancoDeProdutos.size());
        }
        bancoDeProdutos.add(produto);
        return produto;
    }

    @Override
    public Optional<Produto> findById(int id) {
        return bancoDeProdutos.stream().filter(p -> id == p.getId()).findFirst();
    }

    @Override
    public List<Produto> delete(int id) {
        bancoDeProdutos.remove(id);
        return bancoDeProdutos;
    }
}
