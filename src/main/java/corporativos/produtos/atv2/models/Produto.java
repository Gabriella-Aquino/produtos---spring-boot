package corporativos.produtos.atv2.models;

public class Produto {
  private Long id;
  private String nome;
  private Double preco;
  private Integer quantidade;

  public Long getId(){
    return id;
  }
  public void setId(long id){
    this.id = id;
  }

  public String getNome(){
    return nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
}