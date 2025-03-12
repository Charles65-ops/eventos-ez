package com.eventos.services;

import com.eventos.dtos.CidadeDTO;
import com.eventos.models.Cidade;
import com.eventos.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public CidadeDTO salvarCidade(CidadeDTO cidadeDTO) {
        Cidade cidade = converterCidadeDTOParaCidade(cidadeDTO);
        cidade = cidadeRepository.save(cidade);
        return converterCidadeParaCidadeDTO(cidade);
    }

    private CidadeDTO converterCidadeParaCidadeDTO(Cidade cidade) {
        CidadeDTO cidadeDTO = new CidadeDTO();
        cidadeDTO.setId(cidade.getId());
        cidadeDTO.setNome(cidade.getNome());
        cidadeDTO.setEstado(cidade.getEstado());
        return cidadeDTO;
    }

    public Cidade converterCidadeDTOParaCidade(CidadeDTO cidadeDTO) {
        Cidade cidade = new Cidade();
        cidade.setId(cidadeDTO.getId());
        cidade.setNome(cidadeDTO.getNome());
        cidade.setEstado(cidadeDTO.getEstado());
        return cidade;
    }

    public Cidade buscarCidadePorId(Long id) {
        return cidadeRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Cidade não encontrada"));
    }

    public <CidadeDTo> CidadeDTo atualizarCidade(Long id, CidadeDTO cidadeDTO) {
        if(Objects.isNull(cidadeRepository.findById(id))) {
            throw new IllegalArgumentException("Cidade não encontrada");
        }
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Cidade não encontrada"));

        cidade = converterCidadeDTOParaCidade(cidadeDTO);
        cidadeRepository.save(cidade);
        return (CidadeDTo) converterCidadeParaCidadeDTO(cidade);

    }
}
