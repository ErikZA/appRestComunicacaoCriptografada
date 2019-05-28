package com.followzuoComunicacaoCriptografada.ComunicacaoCriptografada.dominio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface responseTabelRepository extends JpaRepository<responseTabel, Long> {


    List<responseTabel> findAllByUserID(String userID);
}
