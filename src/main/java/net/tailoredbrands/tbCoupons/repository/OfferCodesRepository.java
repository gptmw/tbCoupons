package net.tailoredbrands.tbCoupons.repository;


import net.tailoredbrands.tbCoupons.entity.OfferCodes;
import net.tailoredbrands.tbCoupons.entity.keyids.OfferCodeKeyID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface OfferCodesRepository extends JpaRepository<OfferCodes, OfferCodeKeyID> {

    @Query(
            value = "SELECT oc FROM OfferCodes oc WHERE oc.offerCode = :offerCode")
    List<OfferCodes> findByCodeType(@Param("offerCode") String offerCode);
}
