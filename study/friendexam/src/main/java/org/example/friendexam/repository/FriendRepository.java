package org.example.friendexam.repository;

import org.example.friendexam.domain.Friend;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Long> {
    Page<Friend> findAll(Pageable sortedByDescId);
}
