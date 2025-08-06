/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.gabriel.FastAndFuriousFood.model.service;

import java.util.Optional;
import local.gabriel.FastAndFuriousFood.domain.model.Produto;
import local.gabriel.FastAndFuriousFood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ppjata
 */

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Optional<Produto> findByCategoria(String categoria){
        return produtoRepository.findByCategoria(categoria);
    }
    
    public void excluir(long id){
        produtoRepository.deleteById(id);
    }
    
    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }
    
}
