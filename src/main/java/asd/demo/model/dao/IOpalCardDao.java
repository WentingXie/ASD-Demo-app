package asd.demo.model.dao;

import asd.demo.model.OpalCard;

public interface IOpalCardDao {

	OpalCard findOpalCardBySequenceAndSecurityNumber(String sequenceNumber, String securityNumber);

	OpalCard getOneOpalCardByProducTypeId(String productTypeId);

	int updateOpalCardStatusById(String id, int status);

	OpalCard findOpalCardById(String id);

	String updateAllOpalCardsStatus();

}
