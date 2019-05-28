package com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada;

import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.responseTabel;
import com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio.responseTabelRepository;
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
	private responseTabelRepository responseTabelRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void listaTodosPorUserID(){
		responseTabel responseTabel = new responseTabel();
		responseTabel.setMensagemRecebida("salame");
		responseTabel.setUserID("123");
		responseTabelRepository.save(responseTabel);
		responseTabel responseTabel1 = new responseTabel();
		responseTabel1.setMensagemRecebida("mortadela");
		responseTabel1.setUserID("123");
		responseTabelRepository.save(responseTabel1);
		responseTabel responseTabel2 = new responseTabel();
		responseTabel2.setMensagemRecebida("abrobiha");
		responseTabel2.setUserID("111");
		responseTabelRepository.save(responseTabel2);
		List<responseTabel> lista = responseTabelRepository.findAllByUserID("123");
		System.out.println("------------------------\n\n\n"+lista.toString()+"------------------------\n\n\n");
		assertEquals(lista.get(1).getUserID(),"123");
	}

}
