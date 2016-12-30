package domain;

import java.io.Serializable;

/**
 * Created by gzy on 2016/12/29.
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 8751282105532159742L;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
