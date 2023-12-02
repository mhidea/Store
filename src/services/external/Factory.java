package services.external;

import java.util.HashMap;
import helper.ConfigManager;

public class Factory {

    public static MelatBank getMelatBank() {
        HashMap<String, String> crs = ConfigManager.getInstance().credentials(MelatBank.class.getName());
        MelatBank m = new MelatBank(crs.get("token"));
        return m;
    }

    public static Post getPost() {
        HashMap<String, String> crs = ConfigManager.getInstance().credentials(Post.class.getName());
        Post m = new Post(crs.get("username"), crs.get("password"));
        return m;
    }

}
