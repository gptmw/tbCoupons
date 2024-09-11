package net.tailoredbrands.tbCoupons.entity.keyids;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OfferCodeKeyID implements Serializable {

    @Column(name = "OFFER_CODE", nullable=false)
    private String offerCode;

}
