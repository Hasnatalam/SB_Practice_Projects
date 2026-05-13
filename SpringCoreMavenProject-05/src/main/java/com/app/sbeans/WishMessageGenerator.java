package com.app.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class WishMessageGenerator {
	LocalDateTime lt;
	
	@Autowired
	public WishMessageGenerator(LocalDateTime lt) {
		this.lt=lt;
	}
	
	
	public String getWishMassage() {
		if(lt.getHour()>5 && lt.getHour()<=12) {
			return "Good Morning";
		}
		if(lt.getHour()>12 && lt.getHour()<=16) {
			return "Good After noon";
		}
		if(lt.getHour()>16 && lt.getHour()<=21) {
			return "Good Evening";
		}
		return "Sleeping Time";
	}
}
