package Entidade;

public class AlunoTreino {

    private int alunoId;
    private int treinoId;
    private String alunoNome;
    private String treinoNome;

    public AlunoTreino() {
    }

    public AlunoTreino(int alunoId, int treinoId) {
        this.alunoId = alunoId;
        this.treinoId = treinoId;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getTreinoId() {
        return treinoId;
    }

    public void setTreinoId(int treinoId) {
        this.treinoId = treinoId;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getTreinoNome() {
        return treinoNome;
    }

    public void setTreinoNome(String treinoNome) {
        this.treinoNome = treinoNome;
    }
}
