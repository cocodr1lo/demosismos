package com.demosismos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demosismos.model.Sismo;
import com.demosismos.services.DemoSismosService;
import com.google.gson.Gson;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
@RequestMapping(path = "/earthquakes", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoSismosController {
	
	private static final Logger log = LoggerFactory.getLogger(DemoSismosController.class);
    @Autowired
    private DemoSismosService earthquakesService;

    
    @GetMapping(value = "/porFecha/{starttime}/{endtime}",  produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<String> listSismosPorFecha( @PathVariable("starttime") String starttime,
    										   @PathVariable("endtime") String endtime) { 
    			String param1 = "starttime";
    			String param2 = "endtime";
    			String value1 = starttime;
    			String value2 = endtime;
			try {
				
				List<String> earthQuakes = earthquakesService.callEqApi(param1,value1,param2,value2); 
				if(earthQuakes != null){
					return  earthQuakes;
				}

			} catch (Exception ex) {
				log.error("ep-porFecha", ex);
			}
				return null;
			}
    
    @GetMapping(value = "/porMagnitud/{minmagnitude}/{maxmagnitude}",  produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<String> listSismosPorMagnitud( @PathVariable("minmagnitude") String minmagnitude,
    										   		@PathVariable("maxmagnitude") String maxmagnitude) { 

    		String param1 = "minmagnitude";
    		String param2 = "maxmagnitude";
    		String value1 = minmagnitude;
    		String value2 = maxmagnitude;
			try {
				
				List<String> earthQuakes = earthquakesService.callEqApi(param1,value1,param2,value2); 
				if(earthQuakes != null){
					return  earthQuakes;
				}

			} catch (Exception ex) {
				log.error("ep-porMagnitud", ex);
			}
			return null;
	}
 
}
