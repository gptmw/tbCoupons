package net.tailoredbrands.tbCoupons.entity.keyids;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class CouponKeyID implements Serializable {

    @Column(name = "OFFER_CODE")
    private String offerCode;
    @Column(name = "COUPON_NUMBER")
    private String couponNumber;

    public CouponKeyID() {
    }
    public CouponKeyID(String offerCode, String couponNumber) {
        this.offerCode = offerCode;
        this.couponNumber = couponNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouponKeyID that = (CouponKeyID) o;
        return Objects.equals(offerCode, that.offerCode) &&
                Objects.equals(couponNumber, that.couponNumber);

    }

    @Override
    public int hashCode() {
        return Objects.hash(offerCode, couponNumber);
    }
}
