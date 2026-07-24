package dataReader;

import java.io.File;
import java.util.ArrayList;
import model.RadarData;

public abstract class RadarDataReader {

    public ArrayList<RadarData> readRadarData(String filePath) {
        File file = openFile(filePath);
        return parseData(file);
    }

    private File openFile(String filePath) {
        return new File(filePath);
    }

    public abstract ArrayList<RadarData> parseData(File file);
    
}
