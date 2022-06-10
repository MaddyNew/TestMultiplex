package com.mutiplex.screen.service;

import com.mutiplex.screen.dto.ScreenDetailDto;
import com.mutiplex.screen.dto.ScreenDto;

public interface ScreenService {
	
	public ScreenDetailDto register(ScreenDto screenDto, String multiplexId);

}
