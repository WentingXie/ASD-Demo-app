package asd.demo.service;

import asd.demo.model.OpalCard;

public interface IOpalCardService {
	OpalCard getOneOpalCardBySequenceAndSecurityNumber(String sequenceNumber, String securityNumber);

	OpalCard getOneOpalCardByProducTypeId(String producTypeId);

	String initAllOpalCardsStatus();

	int updateOpalStatus(OpalCard oc);

	OpalCard checkOneOpalCardBySequenceNumber(String opalCardSequenceNumber);

}
