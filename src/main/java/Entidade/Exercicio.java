package Entidade;

public class Exercicio {

    private int id;
    private String nome;
    private String descricao;
    private int equipamentoId;

    public Exercicio() {
    }

    public Exercicio(int id, String nome, String descricao, int equipamentoId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.equipamentoId = equipamentoId;
    }

    public Exercicio(String nome, String descricao, int equipamentoId) {
        this.nome = nome;
        this.descricao = descricao;
        this.equipamentoId = equipamentoId;
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

    public int getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(int equipamentoId) {
        this.equipamentoId = equipamentoId;
    }
}
