package br.com.dio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Block {
    protected Long blockId;
    public String blockCause;
    public String unblockCause;
    public OffsetDateTime blockIn;
    public OffsetDateTime unblockIn;
    public Boolean isBlocked;

    public Long cardId;
}
