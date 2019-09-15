package asd.demo.model.dao;

import asd.demo.model.Feedback;

public interface IFeedbackDao {
	int insertFeedback(Feedback feedback);
        int deleteFeedback(String Id);
        Feedback[] getFeedbackList();

}
