package com.tms.lesson44.hw.validator;

import com.tms.lesson44.hw.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    @Autowired
    private StudentDao studentDao;

    public boolean isIdValid(int id) {
        return this.studentDao.getStudent(id) != null;
    }
}
