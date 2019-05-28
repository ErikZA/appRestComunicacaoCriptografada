package com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.conrtroller;
import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.responseTabel;
import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.responseTabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "/api")
public class mensagemResource {

    @Autowired
    private responseTabelRepository responseTabelRepository;

    private fzup_caxkkt2b6z2u fll = new fzup_caxkkt2b6z2u();

    private responseTabel novaMensagen;

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
    public String[] retornaMensagens(HttpServletRequest request) throws Exception {
        System.out.println(request.toString());
        String encrypt_string = request.getParameter("fzupresponse");
        String usermessage = fll.decrypt(encrypt_string);
        List<String> user = Arrays.asList(usermessage.split(";"));
        System.out.println("------------------------\n\n\n"+user.toString()+"------------------------\n\n\n");
        List<responseTabel> lista = responseTabelRepository.findAllByUserID(user.get(1));
        if (user.get(2).equalsIgnoreCase("ListAll()")) {
            String[] result = fll.submit(new String[]{
                    "FZUP_COMMAND = smsg",
                    "FZUP_USER    = " + user.get(1),
                    "FZUP_MSGTEXT = " +lista.toString()});

            return result;
        } else {
            novaMensagen = new responseTabel();
            novaMensagen.setUserID(user.get(1));
            novaMensagen.setMensagemRecebida(user.get(2));
            responseTabelRepository.save(novaMensagen);
            String[] result = fll.submit(new String[]{
                    "FZUP_COMMAND = smsg",
                    "FZUP_USER    = " + user.get(1),
                    "FZUP_MSGTEXT = MENSAGEM SALVA NO REPOSITORIO"});
            return result;
        }
    }


}
