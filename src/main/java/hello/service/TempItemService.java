package hello.service;

import hello.dto.TempItemDTO;
import hello.entity.TempItem;
import hello.exception.CustomDatabaseException;
import hello.repository.CustomConfigRepository;
import hello.repository.DisplayOptionsRepository;
import hello.repository.LegacyConfigRepository;
import hello.repository.TempItemRepository;
import hello.entity.CustomConfig;
import hello.entity.LegacyConfig;
import hello.entity.DisplayOptions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class TempItemService {

    private final TempItemRepository tempItemRepository;
    private final CustomConfigRepository customConfigRepository;
    private final LegacyConfigRepository legacyConfigRepository;
    private final DisplayOptionsRepository displayOptionsRepository;

    public TempItemService(TempItemRepository tempItemRepository, 
                           CustomConfigRepository customConfigRepository, 
                           LegacyConfigRepository legacyConfigRepository, 
                           DisplayOptionsRepository displayOptionsRepository) {
        this.tempItemRepository = tempItemRepository;
        this.customConfigRepository = customConfigRepository;
        this.legacyConfigRepository = legacyConfigRepository;
        this.displayOptionsRepository = displayOptionsRepository;
    }

    public void insertTempItem(TempItemDTO tempItemDTO) {
        validateTempItemDTO(tempItemDTO);
        TempItem tempItem = new TempItem();
        tempItem.setCustomerSegment(tempItemDTO.getCustomerSegment());
        tempItem.setRegionName(tempItemDTO.getRegionName());
        tempItem.setProductCategory(tempItemDTO.getProductCategory());
        tempItem.setSalesAmount(tempItemDTO.getSalesAmount());
        tempItem.setTaxRate(tempItemDTO.getTaxRate());
        tempItem.setStockLevel(tempItemDTO.getStockLevel());
        tempItem.setShippingCost(tempItemDTO.getShippingCost());
        tempItem.setWarehouseCapacity(tempItemDTO.getWarehouseCapacity());
        tempItem.setEmployeePerformance(tempItemDTO.getEmployeePerformance());
        tempItem.setLogisticsEfficiency(tempItemDTO.getLogisticsEfficiency());
        tempItem.setSupplierRating(tempItemDTO.getSupplierRating());
        tempItem.setITSecurityRating(tempItemDTO.getITSecurityRating());
        tempItem.setRefundAmount(tempItemDTO.getRefundAmount());
        tempItem.setQualityAssuranceScore(tempItemDTO.getQualityAssuranceScore());
        tempItem.setPromotionDiscount(tempItemDTO.getPromotionDiscount());
        tempItem.setFinancialStabilityIndex(tempItemDTO.getFinancialStabilityIndex());
        tempItem.setRiskCategory(tempItemDTO.getRiskCategory());
        tempItem.setEcoSustainabilityIndex(tempItemDTO.getEcoSustainabilityIndex());
        tempItem.setOrderId(generateOrderId());
        
        try {
            tempItemRepository.save(tempItem);
        } catch (Exception e) {
            throw new CustomDatabaseException("Error saving TempItem", e);
        }
    }

    public List<DisplayOptions> generateTempItemsReport() {
        List<DisplayOptions> result = new ArrayList<>();
        try {
            List<CustomConfig> customConfigs = customConfigRepository.findByModule("SALES");
            for (CustomConfig cc : customConfigs) {
                List<DisplayOptions> displayOptions = displayOptionsRepository.findByConfigId(cc.getConfigId());
                result.addAll(displayOptions);
            }
            List<LegacyConfig> legacyConfigs = legacyConfigRepository.findByModule("MARKETING_DATA");
            for (LegacyConfig lc : legacyConfigs) {
                List<DisplayOptions> displayOptions = displayOptionsRepository.findByConfigId(lc.getConfigId());
                result.addAll(displayOptions);
            }
        } catch (Exception e) {
            throw new CustomDatabaseException("Error generating report", e);
        }
        return new ArrayList<>(new HashSet<>(result));
    }

    private void validateTempItemDTO(TempItemDTO tempItemDTO) {
        if (tempItemDTO == null) {
            throw new IllegalArgumentException("TempItemDTO cannot be null");
        }
        if (tempItemDTO.getCustomerSegment() == null || tempItemDTO.getRegionName() == null ||
            tempItemDTO.getProductCategory() == null || tempItemDTO.getSalesAmount() == null ||
            tempItemDTO.getTaxRate() == null || tempItemDTO.getStockLevel() == null ||
            tempItemDTO.getShippingCost() == null || tempItemDTO.getWarehouseCapacity() == null ||
            tempItemDTO.getEmployeePerformance() == null || tempItemDTO.getLogisticsEfficiency() == null ||
            tempItemDTO.getSupplierRating() == null || tempItemDTO.getITSecurityRating() == null ||
            tempItemDTO.getRefundAmount() == null || tempItemDTO.getQualityAssuranceScore() == null ||
            tempItemDTO.getPromotionDiscount() == null || tempItemDTO.getFinancialStabilityIndex() == null ||
            tempItemDTO.getRiskCategory() == null || tempItemDTO.getEcoSustainabilityIndex() == null) {
            throw new IllegalArgumentException("All fields in TempItemDTO must be provided");
        }
    }

    private String generateOrderId() {
        return UUID.randomUUID().toString();
    }
}