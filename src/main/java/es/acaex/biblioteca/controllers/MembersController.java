package es.acaex.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.acaex.biblioteca.dtos.MemberCreate;
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
    public Member save(MemberCreate memberCreate) {
        Member member = Member.builder()
                .email(memberCreate.getEmail())
                .username(memberCreate.getUsername())
                .build();

        return repository.save(member);
    }

    @GetMapping("{memberId}")
    public Member findByid(@PathVariable("memberId") long memberId) {
        return repository.findById(memberId).orElseThrow();
    }

    @DeleteMapping("{memberId}")
    public String deleteByid(@PathVariable("memberId") long memberId) {
        // Optional<Member> optional = repository.findById(memberId)
        // optional.orElseThrow();

        repository.findById(memberId).orElseThrow();
        repository.deleteById(memberId);
        return "Ha ido todo correctamente";
    }

    @PutMapping("{memberId}")
    public Member updateById(@PathVariable("memberId") long id, @RequestBody MemberCreate update) {
        Member entity = Member.builder()
                .id(id)
                .username(update.getUsername())
                .email(update.getEmail())
                .build();
        return repository.save(entity);
    }

}
