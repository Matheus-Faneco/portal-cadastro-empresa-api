package br.com.empresa.portal_cadastro_empresa.controller;

import br.com.empresa.portal_cadastro_empresa.model.Empresa;
import br.com.empresa.portal_cadastro_empresa.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmpresaController {

    private final EmpresaService service;

    @PostMapping
    public ResponseEntity<Empresa> cadastrar(
            @RequestBody Empresa empresa,
            @RequestParam boolean usuarioInterno) {
        return ResponseEntity.ok(service.cadastrar(empresa, usuarioInterno));
    }

    @PutMapping("/{id}/aprovar")
    public ResponseEntity<Empresa> aprovar(@PathVariable Long id) {
        return ResponseEntity.ok(service.aprovar(id));
    }

    @PutMapping("/{id}/reprovar")
    public ResponseEntity<Empresa> reprovar(@PathVariable Long id) {
        return ResponseEntity.ok(service.reprovar(id));
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<Empresa>> listarPendentes() {
        return ResponseEntity.ok(service.listarPendentes());
    }
}
