package com.rushit.model.dao;

import java.util.HashMap;
import java.util.List;

import com.rushit.model.vo.Fav;
import com.rushit.model.vo.Review;

public interface ReviewDAO {

	void insertReview(Review review);

	List<Review> selectReviewListbyUser(String user_id);
	
	List<Review> selectReviewListbyToilet(String toilet_id);
	
	Review selectReview(Fav love);

	boolean updateReview(Review reivew);
	
	boolean deleteReview(HashMap<String, String> map);

}