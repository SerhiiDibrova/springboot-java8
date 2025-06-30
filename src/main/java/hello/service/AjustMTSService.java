package hello.service;

import hello.model.AjustMTSModel;
import hello.repository.AjustMTSRepository;
import hello.service.Service;
import java.util.List;

public class AjustMTSService implements Service {

    private AjustMTSRepository ajustMTSRepository;

    public AjustMTSService(AjustMTSRepository ajustMTSRepository) {
        this.ajustMTSRepository = ajustMTSRepository;
    }

    public void handleTransaction(AjustMTSModel ajustMTSModel) {
        if (valuesAreValid(ajustMTSModel)) {
            try {
                ajustMTSRepository.executeTransaction(ajustMTSModel);
            } catch (Exception e) {
                throw new RuntimeException("Error executing transaction", e);
            }
        } else {
            throw new IllegalArgumentException("Invalid input values");
        }
    }

    public boolean valuesAreValid(AjustMTSModel ajustMTSModel) {
        return ajustMTSModel != null 
            && ajustMTSModel.isValid() 
            && ajustMTSModel.getTransactionAmount() > 0 
            && ajustMTSModel.getTransactionType() != null 
            && !ajustMTSModel.getTransactionType().isEmpty();
    }

    public List<String> getCashDesks() {
        try {
            return ajustMTSRepository.getCashDesks();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving cash desks", e);
        }
    }

    public List<String> getSlotMachines() {
        try {
            return ajustMTSRepository.getSlotMachines();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving slot machines", e);
        }
    }
}