package factoryDevice;

import java.util.HashMap;
import java.util.Map;

public class FactoryDevice {

    public static IDevice make(String type){
        Map<String, IDevice> deviceMap = new HashMap<>();
        deviceMap.put("android", new Android());

        return deviceMap.containsKey(type.toLowerCase()) ?
                deviceMap.get(type.toLowerCase()) :
                deviceMap.get("android");
    }
}
