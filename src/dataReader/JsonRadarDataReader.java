package dataReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;  

import model.RadarData;  

public class JsonRadarDataReader extends RadarDataReader { 
    
    @Override
    public ArrayList<RadarData> parseData(File file) {  
        
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(file,
                new TypeReference<ArrayList<RadarData>>() {} 
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse radar data.", e);
        }
    }  
}