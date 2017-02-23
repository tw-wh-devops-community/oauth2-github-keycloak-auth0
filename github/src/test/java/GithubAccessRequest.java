/**
 * client_id	string	Required. The client ID you received from GitHub when you registered.
 * client_secret	string	Required. The client secret you received from GitHub when you registered.
 * code	string	Required. The code you received as a response to Step 1.
 * redirect_uri	string	The URL in your application where users will be sent after authorization. See details below about redirect urls.
 * state	string	The unguessable random string you optionally provided in Step 1.
 * Created by hwwei on 2017/2/23.
 */
public class GithubAccessRequest {
    private final String client_id;
    private final String client_secret;
    private final String code;
    private final String redirect_url;
    private final String state;

    public GithubAccessRequest(String client_id, String client_secret, String code_string,
                               String redirect_url, String state) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.code = code_string;
        this.redirect_url = redirect_url;
        this.state = state;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getCode() {
        return code;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public String getState() {
        return state;
    }
}
