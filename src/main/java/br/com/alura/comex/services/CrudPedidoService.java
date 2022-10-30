package br.com.alura.comex.services;

import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.model.Pedido;
import br.com.alura.comex.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class CrudPedidoService {

    private final PedidoRepository pedidoRepository;

    public CrudPedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void salvar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public void atualizar(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public Iterable<Pedido> visualizar() {
        Iterable<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos;
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.getReferenceById(id);
        return pedido;
    }
}
