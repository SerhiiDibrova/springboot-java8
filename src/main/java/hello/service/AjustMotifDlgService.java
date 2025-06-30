package hello.service;

import hello.repository.AjustMotifDlgRepository;
import hello.model.AjustMotifDlg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
public class AjustMotifDlgService {

    private final AjustMotifDlgRepository ajustMotifDlgRepository;

    @Autowired
    public AjustMotifDlgService(AjustMotifDlgRepository ajustMotifDlgRepository) {
        this.ajustMotifDlgRepository = ajustMotifDlgRepository;
    }

    @Transactional
    public AjustMotifDlg save(@Valid AjustMotifDlg ajustMotifDlg) {
        if (ajustMotifDlg == null) {
            throw new NullPointerException("AjustMotifDlg cannot be null");
        }
        if (ajustMotifDlg.getId() == null) {
            throw new IllegalArgumentException("AjustMotifDlg id cannot be null");
        }
        try {
            return ajustMotifDlgRepository.save(ajustMotifDlg);
        } catch (Exception e) {
            throw new RuntimeException("Error saving AjustMotifDlg", e);
        }
    }

    @Transactional
    public void delete(Long id) {
        if (id == null) {
            throw new NullPointerException("Id cannot be null");
        }
        try {
            ajustMotifDlgRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting AjustMotifDlg", e);
        }
    }

    public List<AjustMotifDlg> findAll() {
        try {
            return ajustMotifDlgRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error finding all AjustMotifDlg", e);
        }
    }

    public AjustMotifDlg findById(Long id) {
        if (id == null) {
            throw new NullPointerException("Id cannot be null");
        }
        try {
            return ajustMotifDlgRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Error finding AjustMotifDlg by id", e);
        }
    }
}