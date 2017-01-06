package base.entity;

import java.io.Serializable;

/**
 * \* User: gzy
 * \* Date: 2017/1/4
 * \* Time: 14:03
 * \* Description:
 * \
 */
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
