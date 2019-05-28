package com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.conrtroller;
import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.responseTabel;
import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.responseTabelRepository;
import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.library.bancoDeMensagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "/api")
public class mensagemResource {

    private com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.library.bancoDeMensagens bancoDeMensagens;

    @Autowired
    private responseTabelRepository responseTabelRepository;

    private fzup_caxkkt2b6z2u fll = new fzup_caxkkt2b6z2u();

    public mensagemResource() throws Exception {
    }

    @GetMapping("/mensagem")
    public String chamaMensagem(){
       // bancoDeMensagens banco= new bancoDeMensagens();
       // banco.salvaMensagens();
       //List<responseTabel> lista = responseTabelRepository.findAll();
       return "Cara sucesso";
    }

    @PostMapping("/recebemensagem")
    public void testeMensagem(HttpServletRequest request){
        System.out.println(request.toString());
        // bancoDeMensagens banco= new bancoDeMensagens();
        // banco.salvaMensagens();
        //List<responseTabel> lista = responseTabelRepository.findAll();
    }

    @PostMapping("/salvaCripto")
    public String[] chamaMensagem(HttpServletRequest request) throws Exception {
        System.out.println(request.toString());
        String encrypt_string = request.getParameter("fzupresponse");
        String usermessage = fll.decrypt(encrypt_string);
        List<String> user = Arrays.asList(usermessage.split(";"));
        List<responseTabel> lista = responseTabelRepository.findAllByUserID(user.get(1));
        if (user.get(2).equalsIgnoreCase("ListAll()")) {
            String[] result = fll.submit(new String[]{
                    "FZUP_COMMAND = smsg",
                    "FZUP_USER    = " + user.get(1),
                    "FZUP_MSGTEXT = " +lista.toString()});

            return result;
        } else {
            bancoDeMensagens.salvaMensagens(user);
            String[] result = fll.submit(new String[]{
                    "FZUP_COMMAND = smsg",
                    "FZUP_USER    = " + user.get(1),
                    "FZUP_MSGTEXT = MENSAGEM SALVA NO REPOSITORIO"});
            return result;
        }
    }


}
