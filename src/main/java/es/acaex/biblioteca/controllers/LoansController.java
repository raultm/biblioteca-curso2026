package es.acaex.biblioteca.controllers;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acaex.biblioteca.dtos.LoanCreate;
import es.acaex.biblioteca.models.Copy;
import es.acaex.biblioteca.models.Loan;
import es.acaex.biblioteca.models.Member;
import es.acaex.biblioteca.repositories.CopiesRepository;
import es.acaex.biblioteca.repositories.LoansRepository;
import es.acaex.biblioteca.repositories.MembersRepository;

@RestController
@RequestMapping("loans")
public class LoansController {

    @Autowired
    MembersRepository membersRepository;
    @Autowired
    CopiesRepository copiesRepository;
    @Autowired
    LoansRepository loansRepository;

    @PostMapping("")
    public Loan generarPrestamo(@RequestBody LoanCreate loanCreate) {

        Member member = membersRepository.findById(loanCreate.getMemberId()).orElseThrow();
        Copy copy = copiesRepository.findById(loanCreate.getCopyId()).orElseThrow();

        Date now = new Date();

        Loan loan = Loan.builder()
                .memberId(member.getId())
                .copyId(copy.getId())
                .startedAt(now)
                .returnedAt(null)
                .expiredAt(addDays(now))
                .build();

        return loansRepository.save(loan);
    }

    private Date addDays(Date now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_MONTH, 21);
        return calendar.getTime();
    }

}
