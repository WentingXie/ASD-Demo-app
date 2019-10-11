package asd.demo.service.impl;

import asd.demo.model.OpalCard;
import asd.demo.model.dao.IOpalCardDao;
import asd.demo.model.dao.impl.OpalCardImpl;
import asd.demo.service.IOpalCardService;

public class OpalCardServiceImpl implements IOpalCardService {

	IOpalCardDao opalCardDao = new OpalCardImpl();

	@Override
	public OpalCard getOneOpalCardBySequenceAndSecurityNumber(String sequenceNumber, String securityNumber) {
		return opalCardDao.findOpalCardBySequenceAndSecurityNumber(sequenceNumber, securityNumber);
	}

	@Override
	public OpalCard getOneOpalCardByProducTypeId(String productTypeId) {
		return opalCardDao.getOneOpalCardByProducTypeId(productTypeId);
	}

	@Override
	public String initAllOpalCardsStatus() {
		return opalCardDao.updateAllOpalCardsStatus();
	}

	@Override
	public int updateOpalStatus(OpalCard oc) {
		return opalCardDao.updateOpalCardStatusById(oc.getId(), 1);
	}

	@Override
	public OpalCard checkOneOpalCardBySequenceNumber(String opalCardSequenceNumber) {
		return opalCardDao.findOpalCardBySequenceAndSecurityNumber(opalCardSequenceNumber, null);
	}

}
