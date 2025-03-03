package autorescue.nokia;

import autorescue.dto.KYCMatchRequest;
import autorescue.dto.KYCMatchResponse;
import autorescue.dto.LocationRetrievalResponse;

public interface NokiaClient {

	boolean callDeviceStatus(String phone);

	LocationRetrievalResponse callLocationRetrieval(String phone) throws Exception;

	KYCMatchResponse callKYCMatch(KYCMatchRequest request) throws Exception;

}
