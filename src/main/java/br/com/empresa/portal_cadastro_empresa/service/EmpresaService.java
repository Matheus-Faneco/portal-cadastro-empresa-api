package br.com.empresa.portal_cadastro_empresa.service;

import br.com.empresa.portal_cadastro_empresa.model.Empresa;
import br.com.empresa.portal_cadastro_empresa.model.enums.StatusCadastro;
import br.com.empresa.portal_cadastro_empresa.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository repository;

    public Empresa cadastrar(Empresa empresa, boolean usuarioInterno) {
        if (usuarioInterno) {
            empresa.setStatus(StatusCadastro.APROVADO);
        } else {
            empresa.setStatus(StatusCadastro.PENDENTE);
        }
        return repository.save(empresa);
    }

    public Empresa aprovar(Long id) {
        Empresa empresa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa nao encontrada"));
        empresa.setStatus(StatusCadastro.APROVADO);
        return repository.save(empresa);
    }

    public Empresa reprovar(Long id) {
        Empresa empresa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa nao encontrada"));
        empresa.setStatus(StatusCadastro.REPROVADO);
        return repository.save(empresa);
    }

    public List<Empresa> listarTodas() {
        return repository.findAll();
    }

    public List<Empresa> listarPendentes() {
        return repository.findByStatus(StatusCadastro.PENDENTE);
    }
}
