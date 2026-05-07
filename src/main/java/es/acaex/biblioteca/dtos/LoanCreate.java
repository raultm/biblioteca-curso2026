package es.acaex.biblioteca.dtos;

import lombok.Data;

@Data
public class LoanCreate {

    private Long memberId;
    private Long copyId;
}
