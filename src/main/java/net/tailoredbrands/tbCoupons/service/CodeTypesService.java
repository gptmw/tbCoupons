package net.tailoredbrands.tbCoupons.service;

import net.tailoredbrands.tbCoupons.dto.CodeTypesDTO;

import java.util.List;

public interface CodeTypesService {
    String createCodeType(List<CodeTypesDTO> codeTypeDTO);

    CodeTypesDTO getByCodeKeyId(String codeKey, String codeType);

    List<CodeTypesDTO> getByCodeKey(String codeKey);

    CodeTypesDTO updateCodeType(String codeKey, String codeType, CodeTypesDTO codeTypeDTO);

    void deleteCodeType(String codeKey, String codeType);

}

