/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.zanit.FastAndFuriousFood.model.service;

import java.util.Optional;
import local.zanit.FastAndFuriousFood.domain.model.Produto;
import local.zanit.FastAndFuriousFood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ppjatb
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
