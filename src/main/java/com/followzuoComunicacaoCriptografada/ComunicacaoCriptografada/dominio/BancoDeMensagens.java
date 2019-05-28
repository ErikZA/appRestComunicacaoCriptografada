package com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BancoDeMensagens implements Serializable {

    @Id @GeneratedValue
    private Long id;

    private String userID;

    private String mensagemRecebida;

}
