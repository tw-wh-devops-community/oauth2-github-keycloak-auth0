import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hwwei on 2017/2/23.
 */
@Service
public class GithubAccessService {

    private final String authorize_url;
    private final String accesstoken_url;
    private final String clientId;
    private final String clientSecret;
    private final String userinfo_url;

    @Autowired
    public GithubAccessService(@Value("${AUTHORIZE_URL}") String authorize_url,
                               @Value("${ACCESSTOKEN_URL}") String accesstoken_url,
                               @Value("${ClientID}") String clientId,
                               @Value("${ClientSecret}") String clientSecret,
                               @Value("${UserInfo_URL}") String userinfo_url
    ) {
        this.authorize_url = authorize_url;
        this.accesstoken_url = accesstoken_url;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.userinfo_url = userinfo_url;
    }

    public GitAccessToken getAccessToken(String code, String state) {
        RestTemplate restTemplate = new RestTemplate();
        GithubAccessRequest request = new GithubAccessRequest(clientId, clientSecret, code, "", state);
        MultiValueMap header = new LinkedMultiValueMap();
        header.add("Accept", "application/json");
        HttpEntity entity = new HttpEntity(request, header);
        ResponseEntity<GitAccessToken> response = restTemplate.postForEntity(accesstoken_url, entity, GitAccessToken.class);

        return response.getBody();
    }

    public String getUserInfo(String accesstoken) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("access_token", accesstoken);
        ResponseEntity<String> entity = restTemplate.getForEntity(userinfo_url, String.class, params);
        return entity.getBody();
    }
}
