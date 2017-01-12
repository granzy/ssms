package domain.user;

import base.entity.BaseEntity;

/**
 * \* User: gzy
 * \* Date: 2017/1/10
 * \* Time: 16:43
 * \* Description:
 * \
 */
public class UserStatusHistory extends BaseEntity<Long> {

    private String userId;

    /**
     * 备注信息
     */
    private String reason;

    private String status;

    private String opUserId;

    private String opDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(String opUserId) {
        this.opUserId = opUserId;
    }

    public String getOpDate() {
        return opDate;
    }

    public void setOpDate(String opDate) {
        this.opDate = opDate;
    }
}
