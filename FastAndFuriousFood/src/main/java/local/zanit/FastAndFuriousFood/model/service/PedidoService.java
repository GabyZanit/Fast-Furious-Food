
package local.zanit.FastAndFuriousFood.model.service;


import java.util.List;
import local.zanit.FastAndFuriousFood.domain.model.ItemPedido;
import local.zanit.FastAndFuriousFood.domain.model.Pedido;
import local.zanit.FastAndFuriousFood.domain.model.Produto;
import local.zanit.FastAndFuriousFood.domain.model.StatusPedido;
import local.zanit.FastAndFuriousFood.domain.repository.PedidoRepository;
import local.zanit.FastAndFuriousFood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ppjatb
 */
@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public void excluir(long id) {
        pedidoRepository.deleteById(id);
    }
    
    public Pedido salvarPedido(Pedido pedido) {
    for (ItemPedido item : pedido.getItens()) {
        Produto produto = produtoRepository.findById(item.getProduto().getId())
            .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + item.getProduto().getId()));
        
        item.setProduto(produto);
        item.setPreco(produto.getPreco() * item.getQntd());
        item.setPedido(pedido); // importante!
        item.setPreco(produto.getPreco() * item.getQntd());
    }

    return pedidoRepository.save(pedido);
}
    
     public Pedido salvar(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
     
     public List<Pedido> buscarPorStatus(Enum status) {
      
        return pedidoRepository.findByStatus(status);
    }
    
    }
