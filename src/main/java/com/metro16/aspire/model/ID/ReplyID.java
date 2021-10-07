package com.metro16.aspire.model.ID;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReplyID implements Serializable {
    private static final long serialVersionUID = 8247184027215412602L;
    protected  int replyID;
    protected int questionID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReplyID replyID1)) return false;
        return getReplyID() == replyID1.getReplyID() && getQuestionID() == replyID1.getQuestionID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReplyID(), getQuestionID());
    }
}
