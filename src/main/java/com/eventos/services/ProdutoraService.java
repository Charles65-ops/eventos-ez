package com.eventos.services;

import com.eventos.dtos.ProdutoraDTO;
import com.eventos.models.Produtora;
import com.eventos.repositories.ProdutoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class ProdutoraService {

    @Autowired
    private ProdutoraRepository produtoraRepository;

   public ProdutoraDTO salvarProdutora(ProdutoraDTO produtoraDTO) {
        Produtora produtora = converterProdutoraDTOParaProdutora(produtoraDTO);
        produtora = produtoraRepository.save(produtora);
        return converterProdutoraParaProdutoraDTO(produtora);
    }

    public Produtora buscarProdutoraPorId(Long id) {
        return produtoraRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produtora não encontrada"));
    }

    private Produtora converterProdutoraDTOParaProdutora(ProdutoraDTO produtoraDTO) {
        Produtora produtora = new Produtora();
        produtora.setId(produtoraDTO.getId());
        produtora.setNome(produtoraDTO.getNome());
        produtora.setCpfCnpj(produtoraDTO.getCpfCnpj());
        return produtora;
    }

    private ProdutoraDTO converterProdutoraParaProdutoraDTO(Produtora produtora) {
        ProdutoraDTO produtoraDTO = new ProdutoraDTO();
        produtoraDTO.setId(produtora.getId());
        produtoraDTO.setNome(produtora.getNome());
        produtoraDTO.setCpfCnpj(produtora.getCpfCnpj());
        return produtoraDTO;
    }

    public ProdutoraDTO atualizarProdutora(Long id, ProdutoraDTO produtoraDTO) {
        if(isNull(produtoraRepository.findById(id))) {
            throw new IllegalArgumentException("campo id não encontrada");
        }
        Produtora produtora = produtoraRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produtora não encontrada"));

        produtora = converterProdutoraDTOParaProdutora(produtoraDTO);
        produtoraRepository.save(produtora);
        return converterProdutoraParaProdutoraDTO(produtora);
    }

    public ProdutoraDTO buscarProdutoraPorNome(String nome) {
       return converterProdutoraParaProdutoraDTO(produtoraRepository.findById()
                .orElseThrow(() ->
                        new IllegalArgumentException("Produtora não encontrada")));

    }
}
