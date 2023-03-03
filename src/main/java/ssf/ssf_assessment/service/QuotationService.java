package ssf.ssf_assessment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.stream.JsonCollectors;
import ssf.ssf_assessment.model.Item;
import ssf.ssf_assessment.model.Quotation;

@Service
public class QuotationService {

    public List<String> generateList(Map<String, Item> cartContents){

        List<String> itemList = new ArrayList<>();

        for ( String itemString: cartContents.keySet()){
            itemList.add(itemString);
        }

        System.out.println(itemList);

        return itemList;
    }
    
    public Quotation getQuotations(List<String> items) throws Exception{

        JsonArray array = createJsonArrayFromList(items);

        RequestEntity<JsonArray> req = RequestEntity
			.post("https://quotation.chuklee.com")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.body(array, String.class);

		RestTemplate template = new RestTemplate();

        ResponseEntity<String> resp = template.exchange(req, String.class);

        String payload = resp.getBody();

		System.out.printf("Payload: %s\n", payload);

        return null;
    }

    public JsonArray createJsonArrayFromList(List<String> items) {

        JsonArray jsonArray = items.stream().map(Json::createValue).collect(JsonCollectors.toJsonArray());

        System.out.println("jsonArray>>>" + jsonArray);

        return jsonArray;
        
    }
    
}
