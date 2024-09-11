package net.tailoredbrands.tbCoupons.entity.keyids;

import jakarta.persistence.Column;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CodeKeyID implements Serializable {

    @Column(name = "CODE_KEY", nullable = false)
    private String codeKey;

    @Column(name = "CODE_TYPE", nullable = false)
    private String codeType;

}
