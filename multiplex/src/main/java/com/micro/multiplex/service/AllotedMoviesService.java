package com.micro.multiplex.service;

import java.util.List;

import com.micro.multiplex.document.MultiplexDetail;
import com.micro.multiplex.dto.AddAllotmentDto;
import com.micro.multiplex.dto.AllotmentDetailsDto;
import com.micro.multiplex.dto.MultiplexDetailDto;

public interface AllotedMoviesService {
	public AllotmentDetailsDto addAllotment(AddAllotmentDto addAllotmentDto);
	public List<MultiplexDetail> getMultiplexMovieDetails (String movieId);
}
