package com.arunveersingh.springdata;

import org.springframework.data.domain.AuditorAware;

public class CustomAuditAware implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return "Arun";
	}

}
