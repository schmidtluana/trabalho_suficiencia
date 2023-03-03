package com.example.trabalho_suficiencia;
import com.example.trabalho_suficiencia.dto.ComandaDTO;
import com.example.trabalho_suficiencia.entity.ComandaEntity;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.trabalho_suficiencia.repository.ComandaRepository;
import com.example.trabalho_suficiencia.service.ComandaService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/RestAPIFurb")
@Api(value = "Comandas", protocols = "http")
public class ComandaRestController {

    @Autowired
    @Lazy
    private ComandaService comandaService;
    @Autowired
    private ComandaRepository comandaRepository;

    @GetMapping("/comandas")
    public List<ComandaDTO> listarComandas() {
        return comandaService.buscarComandas();
    }

    @GetMapping("/comandas/{id}")
    public ResponseEntity<ComandaEntity> listarComandaPorId(@PathVariable Long id) {
        ComandaEntity comanda = comandaService.buscarComandaPorId(id);
        if(comanda != null){
            return ResponseEntity.ok(comanda);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/comandas")
    public ComandaEntity cadastrarComanda(@Valid @RequestBody ComandaEntity comanda) {
        return comandaService.saveNewComanda(comanda);
    }

    @PutMapping("comandas/{id}")
    public ResponseEntity<?> atualizarComanda(@PathVariable Long id, @RequestBody ComandaEntity newComanda) {
        ComandaEntity comandaAlterada = comandaService.alterarComanda(id, newComanda);
        if (comandaAlterada != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Comanda alterada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/comandas/{id}")
    public ResponseEntity<?> excluirComanda(@PathVariable Long id) {
        Boolean deletadoComSucesso = comandaService.deletarComanda(id);
        if (deletadoComSucesso) {
            return ResponseEntity.status(HttpStatus.OK).body("Comanda deletada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
