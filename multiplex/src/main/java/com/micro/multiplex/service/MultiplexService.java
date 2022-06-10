package com.micro.multiplex.service;



import com.micro.multiplex.document.MultiplexDetail;
import com.micro.multiplex.dto.MultiplexDetailDto;
import java.util.List;
import com.micro.multiplex.dto.RegisterMultiplexDto;
import com.micro.multiplex.dto.ScreenDetailsDto;
import com.micro.multiplex.dto.UpdateDetailDto;

public interface MultiplexService {
	public MultiplexDetailDto register(RegisterMultiplexDto registerDto);
	public List<MultiplexDetail> getAllMultiplexes();
	public MultiplexDetailDto getMultiplexDetail(String multiplexId);
	public void deleteMultiplex(String multiplexId);
	public MultiplexDetailDto updateMultiplexDetail(String multiplexId,UpdateDetailDto updateDto);
	
	}
