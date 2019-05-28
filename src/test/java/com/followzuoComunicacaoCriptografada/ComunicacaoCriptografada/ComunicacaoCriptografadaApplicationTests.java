package com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada;
import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.BancoDeMensagens;
import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.BancoDeMensagensRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComunicacaoCriptografadaApplicationTests {

	@Autowired
	private BancoDeMensagensRepository BancoDeMensagensRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void listaTodosPorUserID(){
		BancoDeMensagens BancoDeMensagens = new BancoDeMensagens();
		BancoDeMensagens.setMensagemRecebida("salame");
		BancoDeMensagens.setUserID("123");
		BancoDeMensagensRepository.save(BancoDeMensagens);
		BancoDeMensagens bancoDeMensagens1 = new BancoDeMensagens();
		bancoDeMensagens1.setMensagemRecebida("mortadela");
		bancoDeMensagens1.setUserID("123");
		BancoDeMensagensRepository.save(bancoDeMensagens1);
		BancoDeMensagens bancoDeMensagens2 = new BancoDeMensagens();
		bancoDeMensagens2.setMensagemRecebida("abrobiha");
		bancoDeMensagens2.setUserID("111");
		BancoDeMensagensRepository.save(bancoDeMensagens2);
		List<BancoDeMensagens> lista = BancoDeMensagensRepository.findAllByUserID("123");
		System.out.println("------------------------\n\n\n"+lista.toString()+"------------------------\n\n\n");
		assertEquals(lista.get(1).getUserID(),"123");
	}

}
