package corporativos.produtos.atv2.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corporativos.produtos.atv2.models.Produto;

@RestController
@RequestMapping("/api")
public class ProdutoController {
  private ArrayList<Produto> lista = new ArrayList<>();

  @GetMapping("/produtos")
  public List<Produto> produtos() {
    return lista;
  }

  // @GetMapping("produtos/{id}"){
  // public ResponseEntity<Produto> produto(@PathVariable long id) {
  // return lista;
  // }}

  @PostMapping("/produtos")
  public ResponseEntity<String> cadastrarProduto(@RequestBody Produto produto){
    lista.add(produto);
    return ResponseEntity.status(HttpStatus.CREATED).body("produto cadastrado com sucesso");
  }
}
