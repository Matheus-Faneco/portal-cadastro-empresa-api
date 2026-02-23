package br.com.empresa.portal_cadastro_empresa.repository;

import br.com.empresa.portal_cadastro_empresa.model.Empresa;
import br.com.empresa.portal_cadastro_empresa.model.enums.StatusCadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    List<Empresa> findByStatus(StatusCadastro status);

}