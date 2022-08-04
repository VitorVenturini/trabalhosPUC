public class Dinossauro {

    int id;
    String nomeRaca;
    int tipo;
    int categoria;
    double peso;
    double velocidade;

    public Dinossauro(int id, String nomeRaca, int tipo, int categoria, double peso, double velocidade) {
        this.id = id;
        this.nomeRaca = nomeRaca;
        this.tipo = tipo;
        this.categoria = categoria;
        this.peso = peso;
        this.velocidade = velocidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeRaca() {
        return nomeRaca;
    }

    public void setNomeRaca(String nomeRaca) {
        this.nomeRaca = nomeRaca;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public String toString() {
        return "Dinossauro ID " + id + ": categoria = " + categoria + ", " + "raça = " + nomeRaca + ", peso = " + peso
                + " kg, tipo = " + tipo + ", velocidade = " + velocidade + " km/h";
    }
    
}
