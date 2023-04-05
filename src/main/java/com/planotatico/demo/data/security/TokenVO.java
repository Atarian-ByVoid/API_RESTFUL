package com.planotatico.demo.data.security;

import java.util.Date;

public class TokenVO {

    private static final long serialVersionUID = 1L;

    private String username;
    private Boolean authenticated;
    private Date created;
    private Date expiration;
    private String accesToken;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((authenticated == null) ? 0 : authenticated.hashCode());
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((expiration == null) ? 0 : expiration.hashCode());
        result = prime * result + ((accesToken == null) ? 0 : accesToken.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TokenVO other = (TokenVO) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (authenticated == null) {
            if (other.authenticated != null)
                return false;
        } else if (!authenticated.equals(other.authenticated))
            return false;
        if (created == null) {
            if (other.created != null)
                return false;
        } else if (!created.equals(other.created))
            return false;
        if (expiration == null) {
            if (other.expiration != null)
                return false;
        } else if (!expiration.equals(other.expiration))
            return false;
        if (accesToken == null) {
            if (other.accesToken != null)
                return false;
        } else if (!accesToken.equals(other.accesToken))
            return false;
        return true;
    }

    public TokenVO(String username, Boolean authenticated, Date created, Date expiration, Object acessToken, String accesToken) {
        this.username = username;
        this.authenticated = authenticated;
        this.created = created;
        this.expiration = expiration;
        this.accesToken = accesToken;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }

    public TokenVO(String username2, boolean b, Date now, Date validity, String acessToken, String refreshToken){
        
    }

    public TokenVO() {
    }

}
