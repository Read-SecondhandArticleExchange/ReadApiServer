package Read;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.*;

import java.io.IOException;

/**
 * Created by seungki on 2017-07-25.
 */

//위도 경도
public class GeoCoding {
    public  Float[] geoCoding(String location) throws Exception{
        if(location==null)
            return null;

        Geocoder geocoder = new Geocoder();

        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(location).setLanguage("ko").getGeocoderRequest();

        GeocodeResponse geocoderResponse;

        try{
            geocoderResponse=geocoder.geocode(geocoderRequest);
            if(geocoderResponse.getStatus()== GeocoderStatus.OK & !geocoderResponse.getResults().isEmpty()){
                GeocoderResult geocoderResult=geocoderResponse.getResults().iterator().next();
                LatLng latitudeLongitude = geocoderResult.getGeometry().getLocation();

                Float[] coords = new Float[2];
                coords[0] = latitudeLongitude.getLat().floatValue();
                coords[1] = latitudeLongitude.getLng().floatValue();
                return coords;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
        }

}
