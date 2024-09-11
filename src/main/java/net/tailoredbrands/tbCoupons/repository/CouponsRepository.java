package net.tailoredbrands.tbCoupons.repository;

import net.tailoredbrands.tbCoupons.entity.CodeTypes;
import net.tailoredbrands.tbCoupons.entity.Coupons;
import net.tailoredbrands.tbCoupons.entity.keyids.CouponKeyID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CouponsRepository extends JpaRepository<Coupons, CouponKeyID> {

    @Query(
            value = "SELECT ct FROM Coupons ct WHERE ct.offerCode = :offerCode")
    List<Coupons> findByOfferCode(@Param("offerCode") String offerCode);
}
