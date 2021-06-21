package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repositori.ProdutoRepositori;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // essa clase vai receber as requisicoes HTTP
@RequestMapping(value="/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

    @Autowired//crio um ponto de injecao,para que possa usar os metodos para se conectar com o banco de datos
    ProdutoRepositori produtoRepositori;

    @GetMapping("/produtos") //modo get para devolver a lista de produtos
    @ApiOperation(value = " Retorna una lista de Produtos")
    public List<Produto> ListaProdutos(){
          return produtoRepositori.findAll();
    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value = " Retorna um UNICO produto")
    public Produto ListaProdutoUnico(@PathVariable(value = "id") long id){
        return produtoRepositori.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value = " Salva um produto ")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepositori.save(produto);
    }

    @DeleteMapping("/produto")
    @ApiOperation(value = " Deleta um produto")
    public void deleteProduto(@RequestBody Produto produto){
        produtoRepositori.delete(produto);
    }

    @PutMapping("/produto")
    @ApiOperation(value = " Atualiza um produto")
    public Produto atualizarProduto(@RequestBody Produto produto){
        return produtoRepositori.save(produto);
    }
}
