package com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.controller;
import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.BancoDeMensagens;
import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.BancoDeMensagensRepository;
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
public class MensagenResource {

    @Autowired
    private BancoDeMensagensRepository BancoDeMensagensRepository;

    private fzup_caz52ehed5hp fll = new fzup_caz52ehed5hp();

    private BancoDeMensagens novaMensagen;

    public MensagenResource() throws Exception {
    }

    @GetMapping("/mensagem")
    public String chamaMensagem(){
       // bancoDeMensagens banco= new bancoDeMensagens();
       // banco.salvaMensagens();
       //List<BancoDeMensagens> lista = BancoDeMensagensRepository.findAll();
       return "Cara sucesso";
    }

    @PostMapping("/recebemensagem")
    public void testeMensagem(HttpServletRequest request){
        System.out.println(request.toString());
        // bancoDeMensagens banco= new bancoDeMensagens();
        // banco.salvaMensagens();
        //List<BancoDeMensagens> lista = BancoDeMensagensRepository.findAll();
    }

    @PostMapping("/salvaCripto")
    public String[] retornaMensagens(HttpServletRequest request) throws Exception {
        String minhasMensagens = "MInhas Mensagens: \n";
        String encrypt_string = request.getParameter("fzupresponse");
        String usermessage = fll.decrypt(encrypt_string);
        List<String> user = Arrays.asList(usermessage.split(";"));
        //System.out.println("------------------------\n\n\n"+user.toString()+"------------------------\n\n\n");
        List<BancoDeMensagens> lista = BancoDeMensagensRepository.findAllByUserID(user.get(1));
        for(BancoDeMensagens temp : lista){
           minhasMensagens += temp.getMensagemRecebida();
           minhasMensagens += "\n";
        }
        if (user.get(2).equalsIgnoreCase("ListAll")) {
            String[] result = fll.submit(new String[]{
                    "FZUP_COMMAND = smsg",
                    "FZUP_USER    = " + user.get(1),
                    "FZUP_MSGTEXT = " +minhasMensagens});
            System.out.println("------------------------\n\n\n"+user.toString()+" -- lista todos------------------------"+lista.toString()+"\n\n\n"+result);
            return result;
        } else {
            novaMensagen = new BancoDeMensagens();
            novaMensagen.setUserID(user.get(1));
            novaMensagen.setMensagemRecebida(user.get(2));
            BancoDeMensagensRepository.save(novaMensagen);
            String[] result = fll.submit(new String[]{
                    "FZUP_COMMAND = smsg",
                    "FZUP_USER    = " + user.get(1),
                    "FZUP_MSGTEXT = MENSAGEM SALVA NO REPOSITORIO"});
            System.out.println("------------------------\n\n\n"+user.get(1)+" -- Salva Mensagem"+user.get(1)+"------------------------\n\n\n"+result);
            return result;
        }
    }


}
