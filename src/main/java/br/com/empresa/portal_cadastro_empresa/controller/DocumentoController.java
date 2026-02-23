package br.com.empresa.portal_cadastro_empresa.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/documentos")
@CrossOrigin(origins = "*")

public class DocumentoController {

    private static final String PASTA = "uploads/";

    @Operation(summary = "Upload de documento")
    @PostMapping("/{empresaId}")
    public ResponseEntity<String> upload(
            @PathVariable Long empresaId,
            @RequestParam("arquivo") MultipartFile arquivo) throws IOException {

        String[] formatosValidos = {"pdf", "png", "jpg", "jpeg"};
        String extensao = arquivo.getOriginalFilename()
                .substring(arquivo.getOriginalFilename().lastIndexOf(".") + 1)
                .toLowerCase();

        boolean tipoValido = false;
        for (String tipo : formatosValidos) {
            if (extensao.equals(tipo)) {
                tipoValido = true;
                break;
            }
        }

        if (!tipoValido) {
            return ResponseEntity.badRequest()
                    .body("Apenas formatos validos: pdf, png, jpg ou jpeg.");
        }

        Files.createDirectories(Paths.get(PASTA));
        Path destino = Paths.get(PASTA + empresaId + "_" + arquivo.getOriginalFilename());
        Files.write(destino, arquivo.getBytes());

        return ResponseEntity.ok("Documento anexado com sucesso.");
    }
}