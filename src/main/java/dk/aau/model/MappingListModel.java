package dk.aau.model;

import java.util.HashMap;
import java.util.List;

public class MappingListModel {
    
    private HashMap<String, List<String>> icpcToIcdMap = new HashMap<String, List<String>>();
    
    public HashMap<String, List<String>> getIcpcToIcdMap() {
        return icpcToIcdMap;
    } 
    
}

