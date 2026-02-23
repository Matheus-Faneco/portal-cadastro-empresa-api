package br.com.empresa.portal_cadastro_empresa.model;

import br.com.empresa.portal_cadastro_empresa.model.enums.Perfil;
import br.com.empresa.portal_cadastro_empresa.model.enums.StatusCadastro;
import br.com.empresa.portal_cadastro_empresa.model.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFantasia;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @Enumerated(EnumType.STRING)
    private StatusCadastro status;

    private String razaoSocial;
    private String cnpj;
    private String cpf;
    private String identificadorEstrangeiro;
    private boolean faturamentoDireto;

}
