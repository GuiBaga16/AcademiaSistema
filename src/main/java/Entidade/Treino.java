package Entidade;

public class Treino {

    private int id;
    private String nome;
    private String descricao;
    private int tipoTreinoId;
    private String tipoTreinoNome;

    public Treino() {
    }

    public Treino(int id, String nome, String descricao, int tipoTreinoId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipoTreinoId = tipoTreinoId;
    }

    public Treino(String nome, String descricao, int tipoTreinoId) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipoTreinoId = tipoTreinoId;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTipoTreinoId() {
        return tipoTreinoId;
    }

    public void setTipoTreinoId(int tipoTreinoId) {
        this.tipoTreinoId = tipoTreinoId;
    }

    public String getTipoTreinoNome() {
        return tipoTreinoNome;
    }

    public void setTipoTreinoNome(String tipoTreinoNome) {
        this.tipoTreinoNome = tipoTreinoNome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
