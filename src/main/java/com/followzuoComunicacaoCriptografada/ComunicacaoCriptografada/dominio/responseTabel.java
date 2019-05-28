package com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class responseTabel implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String usuario;

    private String mensagemRecebida;

    private String mensagemEnviada;


    public responseTabel(Long id, String mensagemRecebida, String mensagemEnviada, String usuario) {
        this.usuario = usuario;
        this.id = id;
        this.mensagemRecebida = mensagemRecebida;
        this.mensagemEnviada = mensagemEnviada;
    }

    public responseTabel() {
        super();
    }
}
