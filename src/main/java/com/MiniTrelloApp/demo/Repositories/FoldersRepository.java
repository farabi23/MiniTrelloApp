package com.MiniTrelloApp.demo.Repositories;

import com.MiniTrelloApp.demo.Entities.Folders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FoldersRepository extends JpaRepository<Folders, Long> {
}
