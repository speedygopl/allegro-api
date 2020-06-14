package pl.javaleader.allegroapi;

public class Token {
    private String access_token = "";
    private String token_type = "";
    private String refresh_token = "";
    private long expires_in = 0;
    private String scope = "";
    private boolean allegro_api = false;
    private String jti = "";

    @Override
    public String toString() {
        return "Token : " + System.lineSeparator() +
                "access_token last 10 characters='" + access_token.substring(access_token.length()-10) + '\'' + System.lineSeparator() +
                "token_type='" + token_type + '\'' + System.lineSeparator() +
                "refresh_token last 10 characters='" + refresh_token.substring(refresh_token.length()-10) + '\'' + System.lineSeparator() +
                "expires_in=" + expires_in + System.lineSeparator() +
                "scope='" + scope + '\'' + System.lineSeparator() +
                "allegro_api=" + allegro_api + System.lineSeparator() +
                "jti='" + jti + '\'' + System.lineSeparator();
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isAllegro_api() {
        return allegro_api;
    }

    public void setAllegro_api(boolean allegro_api) {
        this.allegro_api = allegro_api;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}
