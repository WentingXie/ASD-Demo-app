package asd.demo.service;

import asd.demo.model.Feedback;

public interface IFeedbackService {

	int insertFeedback(Feedback feedback);
        int deleteFeedback(String email);
        Feedback[] getFeedbackList();

}
