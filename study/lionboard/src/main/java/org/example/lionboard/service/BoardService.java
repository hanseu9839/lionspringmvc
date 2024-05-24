package org.example.lionboard.service;

import lombok.RequiredArgsConstructor;
import org.example.lionboard.domain.Board;
import org.example.lionboard.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
@Controller
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    public Board save(Board board){
        return repository.save(board);
    }

    public Page<Board> boardAll(Pageable pageable){
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "id"));

        return repository.findAll(pageRequest);
    }

    public Board findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public void delete(Board board){
        repository.delete(board);
    }
}
