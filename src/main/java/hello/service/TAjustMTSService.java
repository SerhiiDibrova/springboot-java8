package hello.service;

import hello.model.CashDesk;
import hello.model.SlotMachine;
import hello.model.Transaction;
import hello.repository.CashDeskRepository;
import hello.repository.SlotMachineRepository;
import hello.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TAjustMTSService {

    private static final Logger logger = LoggerFactory.getLogger(TAjustMTSService.class);

    private final CashDeskRepository cashDeskRepository;
    private final SlotMachineRepository slotMachineRepository;
    private final TransactionRepository transactionRepository;

    public TAjustMTSService(CashDeskRepository cashDeskRepository, SlotMachineRepository slotMachineRepository, TransactionRepository transactionRepository) {
        this.cashDeskRepository = cashDeskRepository;
        this.slotMachineRepository = slotMachineRepository;
        this.transactionRepository = transactionRepository;
    }

    public boolean validateUserInput(Long cashDeskId, Long slotMachineId) {
        return ValuesAreValid(cashDeskId, slotMachineId);
    }

    private boolean ValuesAreValid(Long cashDeskId, Long slotMachineId) {
        CashDesk cashDesk = cashDeskRepository.findById(cashDeskId).orElse(null);
        SlotMachine slotMachine = slotMachineRepository.findById(slotMachineId).orElse(null);
        return cashDesk != null && slotMachine != null;
    }

    public String executeTransaction(Long cashDeskId, Long slotMachineId, Double amount) {
        try {
            if (!validateUserInput(cashDeskId, slotMachineId)) {
                return "Invalid cash desk or slot machine selection";
            }
            return HandleTransaction(cashDeskId, slotMachineId, amount);
        } catch (Exception e) {
            return HandleError(e);
        }
    }

    private String HandleTransaction(Long cashDeskId, Long slotMachineId, Double amount) {
        CashDesk cashDesk = cashDeskRepository.findById(cashDeskId).orElse(null);
        SlotMachine slotMachine = slotMachineRepository.findById(slotMachineId).orElse(null);
        Transaction transaction = new Transaction(cashDesk, slotMachine, amount);
        transactionRepository.save(transaction);
        return "Transaction executed successfully";
    }

    public String HandleError(Exception e) {
        logger.error("An error occurred", e);
        return "An error occurred: " + e.getMessage();
    }
}