/**
 * {"access_token":"e72e16c7e42f292c6912e7710c838347ae178b4a", "scope":"repo,gist", "token_type":"bearer"}
 * <p>
 *     "error": "bad_verification_code",
 "error_description": "The code passed is incorrect or expired.",
 "error_uri": "https://developer.github.com/v3/oauth/#bad-verification-code"
 * Created by hwwei on 2017/2/23.
 */
public class GitAccessToken {
    private String access_token;
    private String scope;
    private String token_type;

    private String error;

    private String error_description;

    private String error_uri;

    public GitAccessToken() {
    }

    public GitAccessToken(String access_token, String scope, String token_type) {
        this.access_token = access_token;
        this.scope = scope;
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getScope() {
        return scope;
    }

    public String getToken_type() {
        return token_type;
    }

    @Override
    public String toString() {
        return "GitAccessToken{" +
                "access_token='" + access_token + '\'' +
                ", scope='" + scope + '\'' +
                ", token_type='" + token_type + '\'' +
                ", error='" + error + '\'' +
                ", error_description='" + error_description + '\'' +
                ", error_uri='" + error_uri + '\'' +
                '}';
    }
}
