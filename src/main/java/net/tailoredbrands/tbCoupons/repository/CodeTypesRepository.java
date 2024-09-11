package net.tailoredbrands.tbCoupons.repository;

import net.tailoredbrands.tbCoupons.entity.CodeTypes;
import net.tailoredbrands.tbCoupons.entity.keyids.CodeKeyID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodeTypesRepository extends JpaRepository<CodeTypes, CodeKeyID> {

    @Query(
            value = "SELECT ct FROM CodeTypes ct WHERE ct.codeKey = :codeKey")
    List<CodeTypes> findByCodeType(@Param("codeKey") String codeKey);
}