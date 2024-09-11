package net.tailoredbrands.tbCoupons.service.impl;

import net.tailoredbrands.tbCoupons.dto.CodeTypesDTO;
import net.tailoredbrands.tbCoupons.entity.CodeTypes;
import net.tailoredbrands.tbCoupons.entity.keyids.CodeKeyID;
import net.tailoredbrands.tbCoupons.repository.CodeTypesRepository;
import net.tailoredbrands.tbCoupons.exception.ResourceNotFoundException;
import net.tailoredbrands.tbCoupons.mapper.CodeTypesMapper;
import net.tailoredbrands.tbCoupons.service.CodeTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;


@Service
@AllArgsConstructor
public class CodeTypesServiceImpl implements CodeTypesService {
    @Autowired
    private CodeTypesRepository codeTypeRepository;
    @Override
    public String createCodeType(List<CodeTypesDTO> codeTypeDto){
        //List<CodeTypesDTO> codeTypeDTOList = List.of();

        for (CodeTypesDTO codeType:codeTypeDto){

            CodeTypes newCodeType = CodeTypesMapper.mapToCodeType(codeType);

            CodeTypes savedCodeType = codeTypeRepository.save(newCodeType);
            //codeTypeDTOList.add(savedCodeType);
        }
        return "Successfully loaded the code types.";
    }


    @Override
    public CodeTypesDTO getByCodeKeyId(String codeKey, String codeType) {
        CodeKeyID codeKeyID = new CodeKeyID(codeKey, codeType);
        CodeTypes retrievedCodeType = codeTypeRepository.findById(codeKeyID)
                .orElseThrow(() -> new ResourceNotFoundException("Code Type: " + trim(codeType) + " and Code Key: " + trim(codeKey) + " does not exist."));
        return CodeTypesMapper.mapToCodeTypeDTO(retrievedCodeType);
    }

    @Override
    public List<CodeTypesDTO> getByCodeKey(String codeKey) {
        //codeKeyID codeKeyID = new codeKeyID(codeType);
        List<CodeTypes> retrievedCodeType = codeTypeRepository.findByCodeType(codeKey);

        //List<Code_TypeDTO> codeTypeDTOList = Code_TypeMapper.toDtoList(retrieved_code_type);
        List<CodeTypesDTO> codeTypeDTOList = CodeTypesMapper.toCodeTypeDtos(retrievedCodeType);
        return codeTypeDTOList;
        //return ResponseEntity.ok(codeTypeDTOList).getBody();

    }

    @Override
    public CodeTypesDTO updateCodeType(String codeKey, String codeType, CodeTypesDTO codeTypeDTO) {
        CodeKeyID codeKeyID = new CodeKeyID(codeKey, codeType);
        CodeTypes retrievedCodeType = codeTypeRepository.findById(codeKeyID)
                .orElseThrow(() -> new ResourceNotFoundException("Code Type: " + trim(codeType) + " and Code Key: " + trim(codeKey) + " does not exist."));

        if (codeTypeDTO.getSequence() != 0) {
            retrievedCodeType.setSequence(codeTypeDTO.getSequence());
        }
        if (codeTypeDTO.getCodeDescription() != null) {
            retrievedCodeType.setCodeDescription(codeTypeDTO.getCodeDescription());
        }
        if (codeTypeDTO.getStatus() != null) {
            retrievedCodeType.setStatus(codeTypeDTO.getStatus());
        }
        if (codeTypeDTO.getUpdatedTimestamp() != null) {
            retrievedCodeType.setUpdatedTimestamp(codeTypeDTO.getUpdatedTimestamp());
        }
        if (codeTypeDTO.getUpdatedByUser() != null) {
            retrievedCodeType.setUpdatedByUser(codeTypeDTO.getUpdatedByUser());
        }

        CodeTypes updatedCodeType = codeTypeRepository.save(retrievedCodeType);
        return CodeTypesMapper.mapToCodeTypeDTO(updatedCodeType);


    }

    @Override
    public void deleteCodeType(String codeKey, String codeType) {
        CodeKeyID codeKeyID = new CodeKeyID(codeKey, codeType);
        CodeTypes retrieved_code_type = codeTypeRepository.findById(codeKeyID)
                .orElseThrow(() -> new ResourceNotFoundException("Code Type: " + trim(codeType) + " and Code Key: " + trim(codeKey) + " does not exist."));

        codeTypeRepository.deleteById(codeKeyID);

    }
}
