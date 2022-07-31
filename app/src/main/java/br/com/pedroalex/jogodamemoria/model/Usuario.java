package br.com.pedroalex.jogodamemoria.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDate;

public class Usuario implements Parcelable {

    private String nome;
    private Integer pontos;
    private LocalDate data;

    public Usuario(String nome, Integer pontos, LocalDate data) {
        this.nome = nome;
        this.pontos = pontos;
        this.data = data;
    }

    protected Usuario(Parcel in) {
        this.nome = in.readString();
        this.pontos = in.readInt();
        this.data = (LocalDate) in.readValue(LocalDate.class.getClassLoader());
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeInt(pontos);
        parcel.writeValue(data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getPontos() {
        return pontos;
    }
    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
}
