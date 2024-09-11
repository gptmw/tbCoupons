package net.tailoredbrands.tbCoupons.service;

import net.tailoredbrands.tbCoupons.dto.OfferCodesDTO;

import java.util.List;

public interface OfferCodesService {
    OfferCodesDTO createOfferCode(OfferCodesDTO offerCodeDTO);
    String createOfferCodes(List<OfferCodesDTO> offerCodeDTO);

    OfferCodesDTO getByOfferCodeId(String offerCode);
    List<OfferCodesDTO> getOfferCodes();

    OfferCodesDTO updateOfferCode(String offerCode, OfferCodesDTO offerCodeDTO);
    void deleteOfferCode(String offerCode);

}

