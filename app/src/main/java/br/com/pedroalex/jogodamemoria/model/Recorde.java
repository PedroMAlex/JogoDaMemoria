package br.com.pedroalex.jogodamemoria.model;

public class Recorde {
    private int ID;
    private String NOME;
    private int PONTOS;
    private int TENTATIVAS;
    private String DATA;

    /*
     * Métodos acessores
     */
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getNOME() {
        return NOME;
    }
    public void setNOME(String NOME) {
        this.NOME = NOME;
    }
    public int getPONTOS() {
        return PONTOS;
    }
    public void setPONTOS(int PONTOS) {
        this.PONTOS = PONTOS;
    }
    public int getTENTATIVAS() {
        return TENTATIVAS;
    }
    public void setTENTATIVAS(int TENTATIVAS) {
        this.TENTATIVAS = TENTATIVAS;
    }
    public String getDATA() {
        return DATA;
    }
    public void setDATA(String DATA) {
        this.DATA = DATA;
    }
}