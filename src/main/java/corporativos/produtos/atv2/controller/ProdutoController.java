package corporativos.produtos.atv2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("produtos/{id}")
  public Produto produto(@PathVariable long id) {
    for (Produto produto : lista) {
      if (produto.getId() == id) {
        return produto;
      }
    }
    return null;
  }

  @PostMapping("/produtos")
  public ResponseEntity<String> cadastrarProduto(@RequestBody Produto produto) {
    lista.add(produto);
    return ResponseEntity.status(HttpStatus.CREATED).body("produto cadastrado com sucesso");
  }

  @PutMapping("/produtos/{id}")
  public ResponseEntity<String> editarProduto(@PathVariable long id, @RequestBody Produto produtoAtualizado) {
    for (Produto produto : lista) {
      if (produto.getId() == id) {
        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        return ResponseEntity.ok("Produto atualizado com sucesso");
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
  }

  @DeleteMapping("/produtos/{id}")
  public ResponseEntity<String> deletarProduto(@PathVariable long id) {
    boolean removido = lista.removeIf(produto -> produto.getId() != null && produto.getId().equals(id));
    if (removido) {
      return ResponseEntity.ok("Produto removido com sucesso!");
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
  }

  @GetMapping("/produtos/search")
  public ResponseEntity<List<Produto>> buscarPorNome(@RequestParam String nome) {
    List<Produto> resultados = new ArrayList<>();

    for (Produto produto : lista) {
      if (produto.getNome() != null &&
          produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
        resultados.add(produto);
      }
    }

    if (resultados.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    return ResponseEntity.ok(resultados);
  }
}
