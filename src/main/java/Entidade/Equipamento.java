package Entidade;

public class Equipamento {

    private int id;
    private String nome;
    private String tipo;
    private String marca;
    private int quantidade;
    private String statusAtual;

    public Equipamento() {
    }

    public Equipamento(int id, String nome, String tipo,
            String marca, int quantidade, String statusAtual) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.marca = marca;
        this.quantidade = quantidade;
        this.statusAtual = statusAtual;
    }

    public Equipamento(String nome, String tipo,
            String marca, int quantidade, String statusAtual) {
        this.nome = nome;
        this.tipo = tipo;
        this.marca = marca;
        this.quantidade = quantidade;
        this.statusAtual = statusAtual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatusAtual() {
        return statusAtual;
    }

    public void setStatusAtual(String statusAtual) {
        this.statusAtual = statusAtual;
    }

    @Override
    public String toString() {
        return nome;
    }

}
