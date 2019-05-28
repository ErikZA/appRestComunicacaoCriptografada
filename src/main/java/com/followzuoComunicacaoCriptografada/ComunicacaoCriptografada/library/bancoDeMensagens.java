package com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.library;

import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.responseTabel;
import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.responseTabelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class bancoDeMensagens {

    @Autowired
    private responseTabelRepository responseTabelRepository;

    public void salvaMensagens(List<String> mensagem) {
        responseTabel response = new responseTabel();
        response.setUserID(mensagem.get(1));
        response.setMensagemRecebida(mensagem.get(2));
        responseTabelRepository.save(response);
    }
}
