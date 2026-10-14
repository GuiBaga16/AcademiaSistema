package Entidade;

public class TreinoExercicio {

    private int treinoId;
    private int exercicioId;
    private int series;
    private int repeticoes;
    private double carga;

    public TreinoExercicio() {
    }

    public TreinoExercicio(
            int treinoId,
            int exercicioId,
            int series,
            int repeticoes,
            double carga) {
        this.treinoId = treinoId;
        this.exercicioId = exercicioId;
        this.series = series;
        this.repeticoes = repeticoes;
        this.carga = carga;
    }

    public int getTreinoId() {
        return treinoId;
    }

    public void setTreinoId(int treinoId) {
        this.treinoId = treinoId;
    }

    public int getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(int exercicioId) {
        this.exercicioId = exercicioId;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }
}
