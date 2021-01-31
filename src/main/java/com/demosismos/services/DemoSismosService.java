package com.demosismos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demosismos.model.Sismo;
import com.demosismos.repositories.DemoSismosRepository;



@Service
public class DemoSismosService {
	
    @Autowired
    DemoSismosRepository earthquakesRepository;

    public List<String> callEqApi(String param1,String value1 ,String param2,String value2) {  
		
		  List<String> earthquakes = new ArrayList<String>();
		  earthquakes=earthquakesRepository.callEqApiByParams(param1,value1,param2,value2); 
	
	        return earthquakes;
	} 
    
    public int create(Sismo earthquake) {
    	System.out.println("llama a la insercion en la bd");
        return earthquakesRepository.insert(earthquake);
    }


}
