package example.demo.service;

import example.demo.domain.EnrollEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollService {
    @Autowired
    private EnrollRepository enrollRepository;

    @Transactional
    public void updateEnrollGrade(int sno, String cno) {
        enrollRepository.updateEnrollGrade(sno, cno);
    }
}
