package com.produtos.apirest.repositori;

import com.produtos.apirest.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
// o JPARepositori falicita pq, possue varios metodos prontos para fazer persistencia no banco de dados
//metodos, save, delete.

public interface ProdutoRepositori extends JpaRepository<Produto,Long> {
    Produto findById(long id);// crio o metodo para lista um so elemento

}
