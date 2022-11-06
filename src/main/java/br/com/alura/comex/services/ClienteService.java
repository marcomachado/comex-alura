package br.com.alura.comex.services;

import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;


    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void salvar(Cliente c) {
        clienteRepository.save(c);
    }

    public void atualizar(Cliente c) {
        clienteRepository.save(c);
    }

    public Iterable<Cliente> visualizar() {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente buscarPorId(Long id) {
        Cliente cliente = clienteRepository.getReferenceById(id);
        return cliente;
    }
}
