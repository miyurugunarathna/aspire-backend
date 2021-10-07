package com.metro16.aspire.model;

import com.metro16.aspire.model.ID.ReplyID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "Reply")
@Table(name = "reply")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int replyID;
    private String description;
    private int repliedPersonID;
    private Date repliedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reply reply)) return false;
        return getReplyID() == reply.getReplyID() && getRepliedPersonID() == reply.getRepliedPersonID() && Objects.equals(getDescription(), reply.getDescription()) && Objects.equals(getRepliedDate(), reply.getRepliedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReplyID(), getDescription(), getRepliedPersonID(), getRepliedDate());
    }
}
