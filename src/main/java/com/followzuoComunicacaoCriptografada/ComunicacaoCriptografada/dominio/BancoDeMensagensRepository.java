package com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BancoDeMensagensRepository extends JpaRepository<BancoDeMensagens, Long> {

    List<BancoDeMensagens> findAllByUserID(String userID);
}
