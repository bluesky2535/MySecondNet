package com.service;

import com.domain.MidOrder;

public interface MidOrderDao {
	
    

	public void save(MidOrder midOrder);

	public MidOrder finBymidorderid(String midorderid);

	

}
