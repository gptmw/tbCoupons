package net.tailoredbrands.tbCoupons.mapper;

import net.tailoredbrands.tbCoupons.dto.CodeTypesDTO;
import net.tailoredbrands.tbCoupons.entity.CodeTypes;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
public class CodeTypesMapper {

    @Autowired
    public static CodeTypesDTO mapToCodeTypeDTO(CodeTypes codeType) {
        return new CodeTypesDTO(
                codeType.getCodeKey(),
                codeType.getCodeType(),
                codeType.getStatus(),
                codeType.getSequence(),
                codeType.getCodeDescription(),
                codeType.getCreatedTimestamp(),
                codeType.getCreatedByUser(),
                codeType.getUpdatedTimestamp(),
                codeType.getUpdatedByUser()
        );
    }

    public static CodeTypes mapToCodeType(CodeTypesDTO codeTypeDTO) {
        return new CodeTypes(
                codeTypeDTO.getCodeKey(),
                codeTypeDTO.getCodeType(),
                codeTypeDTO.getStatus(),
                codeTypeDTO.getSequence(),
                codeTypeDTO.getCodeDescription(),
                codeTypeDTO.getCreatedTimestamp(),
                codeTypeDTO.getCreatedByUser(),
                codeTypeDTO.getUpdatedTimestamp(),
                codeTypeDTO.getUpdatedByUser()
        );


    }

    public static List<CodeTypesDTO> toCodeTypeDtos(List<CodeTypes> codeTypes) {
        List<CodeTypesDTO> codeTypeDTOS = null;
        if (codeTypes != null) {
            codeTypeDTOS = codeTypes.stream()
                    .map(CodeTypes -> mapToCodeTypeDTO(CodeTypes))
                    .collect(Collectors.toList());

        }
        return codeTypeDTOS;
    }
}
