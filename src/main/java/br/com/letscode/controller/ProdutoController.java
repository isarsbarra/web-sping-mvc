package br.com.letscode.controller;

import br.com.letscode.exception.BadRequestException;
import br.com.letscode.model.Produto;
import br.com.letscode.persistence.ProdutoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoDao produtoDao;

    @GetMapping
    public List<Produto> listarProdutos (){
        return produtoDao.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionarProduto(@RequestBody Produto produto){
        produto.setId(null);
        if(produto.getNome() == null){
            throw new BadRequestException("nome", "não pode ser nulo");
        }
        return produtoDao.save(produto);
    }

    @GetMapping(path ="/{id}")
    public ResponseEntity<Produto> exibirProduto (@PathVariable("id") int id){

        Optional<Produto> produtoOpt = produtoDao.findById(id);

        return produtoOpt.map(p -> ResponseEntity.ok(p)).orElse(ResponseEntity.noContent().build());
    }

    @DeleteMapping(path = "/{id}")
    public List<Produto> deletarProduto(@PathVariable("id") int id){
        return produtoDao.delete(id);
    }
}
