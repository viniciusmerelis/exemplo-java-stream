package exemplo.stream.model;

public class Fatura {

    private String email;
    private double valor;
    private boolean pago;

    public Fatura(String email, double valor, boolean pago) {
        this.email = email;
        this.valor = valor;
        this.pago = pago;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean estaEmRisco() {
        return valor > 250 ? true : false;
    }

}
