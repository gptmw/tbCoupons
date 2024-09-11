package net.tailoredbrands.tbCoupons.service.impl;


import lombok.AllArgsConstructor;
import net.tailoredbrands.tbCoupons.dto.CodeTypesDTO;
import net.tailoredbrands.tbCoupons.dto.OfferCodesDTO;
import net.tailoredbrands.tbCoupons.entity.CodeTypes;
import net.tailoredbrands.tbCoupons.entity.OfferCodes;
import net.tailoredbrands.tbCoupons.entity.keyids.OfferCodeKeyID;
import net.tailoredbrands.tbCoupons.mapper.CodeTypesMapper;
import net.tailoredbrands.tbCoupons.repository.OfferCodesRepository;
import net.tailoredbrands.tbCoupons.exception.ResourceNotFoundException;
import net.tailoredbrands.tbCoupons.mapper.OfferCodesMapper;
import net.tailoredbrands.tbCoupons.service.OfferCodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;


@Service
@AllArgsConstructor
public class OfferCodesServceImpl implements OfferCodesService {

    @Autowired
    private OfferCodesRepository offerCodeRepository;

    @Override
    public OfferCodesDTO createOfferCode(OfferCodesDTO offerCodeDTO) {
        OfferCodes offerCode = OfferCodesMapper.mapToOfferCode(offerCodeDTO);
        OfferCodes savedOfferCode = offerCodeRepository.save(offerCode);
        return OfferCodesMapper.mapToOfferCodeDTO(savedOfferCode);
    }

    @Override
    public String createOfferCodes(List<OfferCodesDTO> offerCodeDto) {

        for (OfferCodesDTO offerCode:offerCodeDto){

            OfferCodes newOfferCode = OfferCodesMapper.mapToOfferCode(offerCode);

            OfferCodes savedOfferCode = offerCodeRepository.save(newOfferCode);
            //codeTypeDTOList.add(savedCodeType);
        }
        return "Successfully loaded the offer codes.";
    }


    @Override
    public OfferCodesDTO getByOfferCodeId(String offerCode) {
        OfferCodeKeyID offerCodeKeyID = new OfferCodeKeyID(offerCode);
        OfferCodes retrievedOfferCode = offerCodeRepository.findById(offerCodeKeyID)
                .orElseThrow(() -> new ResourceNotFoundException("Offer Code: " + trim(offerCode) +  " does not exist."));
        return OfferCodesMapper.mapToOfferCodeDTO(retrievedOfferCode);
    }

    @Override
    public List<OfferCodesDTO> getOfferCodes() {

        List<OfferCodes> retrievedOfferCodes = offerCodeRepository.findAll();

        return OfferCodesMapper.toOfferCodeDtos(retrievedOfferCodes);

    }

    @Override
    public OfferCodesDTO updateOfferCode(String offerCode, OfferCodesDTO offerCodeDTO) {
        OfferCodeKeyID offerCodeKeyID = new OfferCodeKeyID(offerCode);
        OfferCodes retrievedOfferCode = offerCodeRepository.findById(offerCodeKeyID)
                .orElseThrow(() -> new ResourceNotFoundException("Offer Code: " + trim(offerCode) +  " does not exist."));


        if (offerCodeDTO.getOfferDescription() != null) {
            retrievedOfferCode.setOfferDescription(offerCodeDTO.getOfferDescription());
        }
        if (offerCodeDTO.getBrandCode() != null) {
            retrievedOfferCode.setBrandCode(offerCodeDTO.getBrandCode());
        }
        if (offerCodeDTO.getChannelCode() != null) {
            retrievedOfferCode.setChannelCode(offerCodeDTO.getChannelCode());
        }
        if (offerCodeDTO.getCouponCount() != null) {
            retrievedOfferCode.setCouponCount(offerCodeDTO.getCouponCount());
        }
        if (offerCodeDTO.getCouponOptions() != null) {
            retrievedOfferCode.setCouponOptions(offerCodeDTO.getCouponOptions());
        }
        if (offerCodeDTO.getOneTimeUse() != null) {
            retrievedOfferCode.setOneTimeUse(offerCodeDTO.getOneTimeUse());
        }
        if (offerCodeDTO.getEffectiveStartDate() != null) {
            retrievedOfferCode.setEffectiveStartDate(Timestamp.valueOf(offerCodeDTO.getEffectiveStartDate().toLocalDateTime()));
        }
        if (offerCodeDTO.getEffectiveEndDate() != null) {
            retrievedOfferCode.setEffectiveEndDate(Timestamp.valueOf(offerCodeDTO.getEffectiveEndDate().toLocalDateTime()));
        }
        if (offerCodeDTO.getIncludeEncryption() != null) {
            retrievedOfferCode.setIncludeEncryption(offerCodeDTO.getIncludeEncryption());
        }
        if (offerCodeDTO.getMultipleBrands() != null) {
            retrievedOfferCode.setMultipleBrands(offerCodeDTO.getMultipleBrands());
        }
        if (offerCodeDTO.getCouponToCheetah() != null) {
            retrievedOfferCode.setCouponToCheetah(offerCodeDTO.getCouponToCheetah());
        }
        if (offerCodeDTO.getCouponBatch() != null) {
            retrievedOfferCode.setCouponBatch(offerCodeDTO.getCouponBatch());
        }
        if (offerCodeDTO.getCouponPreload() != null) {
            retrievedOfferCode.setCouponPreload(offerCodeDTO.getCouponPreload());
        }
        if (offerCodeDTO.getCouponType() != null) {
            retrievedOfferCode.setCouponType(offerCodeDTO.getCouponType());
        }
        if (offerCodeDTO.getRedemptionType() != null) {
            retrievedOfferCode.setRedemptionType(offerCodeDTO.getRedemptionType());
        }
        if (offerCodeDTO.getOcmStartDate() != null) {
            retrievedOfferCode.setOcmStartDate(offerCodeDTO.getOcmStartDate());
        }
        if (offerCodeDTO.getOcmEndDate() != null) {
            retrievedOfferCode.setOcmEndDate(offerCodeDTO.getOcmEndDate());
        }
        if (offerCodeDTO.getOcmSequenceNumberStart() != null) {
            retrievedOfferCode.setOcmSequenceNumberStart(offerCodeDTO.getOcmSequenceNumberStart());
        }
        if (offerCodeDTO.getOcmSequenceNumberEnd() != null) {
            retrievedOfferCode.setOcmSequenceNumberEnd(offerCodeDTO.getOcmSequenceNumberEnd());
        }

        if (offerCodeDTO.getUpdatedTimestamp() != null) {
            retrievedOfferCode.setUpdatedTimestamp(offerCodeDTO.getUpdatedTimestamp());
        }
        if (offerCodeDTO.getUpdatedByUser() != null) {
            retrievedOfferCode.setUpdatedByUser(offerCodeDTO.getUpdatedByUser());
        }

        OfferCodes updatedOfferCode = offerCodeRepository.save(retrievedOfferCode);
        return OfferCodesMapper.mapToOfferCodeDTO(updatedOfferCode);

    }

    @Override
    public void deleteOfferCode(String offerCode) {
        OfferCodeKeyID offerCodeKeyID = new OfferCodeKeyID(offerCode);
        OfferCodes retrievedOfferCode = offerCodeRepository.findById(offerCodeKeyID)
                .orElseThrow(() -> new ResourceNotFoundException("Offer Code: " + trim(offerCode) +  " does not exist."));

        offerCodeRepository.deleteById(offerCodeKeyID);
    }
}
