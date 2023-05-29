
package model;

public class Mercadoria {
    private int Codigo;
    private String Produto;
    private String Preço;



    public String getProduto() {
        return Produto;
    }

    public void setProduto(String Produto) {
        this.Produto = Produto;
    }

    public String getPreço() {
        return Preço;
    }

    public void setPreço(String Preço) {
        this.Preço = Preço;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
    }
    
    
}
