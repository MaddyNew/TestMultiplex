package com.micro.multiplex.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.micro.multiplex.document.ScreenDetail;
import com.micro.multiplex.dto.ScreenDetailsDto;

public interface ScreenService {
	public List<ScreenDetail> getAllScreens(String multiplexId);
	public ScreenDetailsDto addScreen(String screenName,String multiplexId);
	public List<ScreenDetail> getAvailableScreens(String multiplexId);
}
