package asd.demo.service.impl;

import asd.demo.model.Feedback;
import asd.demo.model.dao.IFeedbackDao;
import asd.demo.model.dao.impl.FeedbackDaoImpl;
import asd.demo.service.IFeedbackService;

public class FeedbackServiceImpl implements IFeedbackService {

	private IFeedbackDao feedbackDao = new FeedbackDaoImpl();


	@Override
	public int insertFeedback(Feedback feedback) {
		return feedbackDao.insertFeedback(feedback);
	}

	@Override
	public int deleteFeedback(String email) {
		return feedbackDao.deleteFeedback(email);
	}

	@Override
	public Feedback[] getFeedbackList() {
		return feedbackDao.getFeedbackList();
	}

}
