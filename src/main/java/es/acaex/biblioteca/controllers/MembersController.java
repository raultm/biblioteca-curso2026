package es.acaex.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acaex.biblioteca.models.Member;
import es.acaex.biblioteca.repositories.MembersRepository;

@RestController
@RequestMapping("members")
public class MembersController {

    @Autowired
    MembersRepository repository;

    // MARK: Listado
    @GetMapping
    public List<Member> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public Member save(Member member) {
        return repository.save(member);
    }

    @GetMapping("{memberId}")
    public Member findByid(@PathVariable("memberId") long memberId) {
        return repository.findById(memberId).orElseThrow();
    }

}
