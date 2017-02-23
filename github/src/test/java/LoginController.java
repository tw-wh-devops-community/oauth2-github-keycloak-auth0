import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hwwei on 2017/2/23.
 */
@Controller
public class LoginController {

    @Autowired
    private GithubAccessService service;

    @RequestMapping(value = "/oauth/{type}/callback", method = RequestMethod.GET)
    @ResponseBody
    public String claaback(@RequestParam(value = "code", required = true) String code,
                                   @RequestParam(value = "state", required = true) String state,
                                   @PathVariable(value = "type") String type,
                                   HttpServletRequest request, Model model) {
        GitAccessToken accessToken = service.getAccessToken(code, state);
        String userInfo = service.getUserInfo(accessToken.getAccess_token());
        return accessToken.toString() + userInfo;
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    @ResponseBody
    public Object success(HttpServletRequest request) {
        return request.getSession().getAttribute("oauthUser");
    }
}
