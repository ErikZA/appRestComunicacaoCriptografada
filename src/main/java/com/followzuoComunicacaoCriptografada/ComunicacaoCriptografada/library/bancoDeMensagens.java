package com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.library;

import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.responseTabel;
import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.responseTabelRepository;

import java.util.List;

public class bancoDeMensagens {


    private responseTabelRepository responseTabelRepository;

    public void salvaMensagens(List<String> mensagem) {
        responseTabel response = new responseTabel();
        response.setUsuario(mensagem.get(1));
        response.setMensagemRecebida(mensagem.get(1));
        responseTabelRepository.save(response);
    }
}
