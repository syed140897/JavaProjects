package com.creativemind.FileBatchUploadProcess.Config;

import org.springframework.batch.item.ItemProcessor;

import com.creativemind.FileBatchUploadProcess.Entity.CustomerDetail;


public class ItemProcesser implements ItemProcessor<CustomerDetail, CustomerDetail>{

	@Override
	public CustomerDetail process(CustomerDetail item) throws Exception {
		return item;
	}

}
